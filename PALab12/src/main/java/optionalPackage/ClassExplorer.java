package optionalPackage;

import compulsoryPackage.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ClassExplorer {
    private int totalTests;
    private int failedTests;
    private int passedTests;

    public ClassExplorer() {
        totalTests = 0;
        failedTests = 0;
        passedTests = 0;
    }

    private void loadClass(String fileName, URLClassLoader classLoader, File file) {
        Class<?> temp = null;
        try {
            temp = Class.forName(fileName, true, classLoader);
        } catch (NoClassDefFoundError e) {
            String name1 = e.getMessage().split(": ")[1]
                    .replace(")", "")
                    .replace("/", "\\");
            File file1 = new File(file.getAbsolutePath().replace(name1 + ".class", ""));
            try {
                URL url = file1.getAbsoluteFile().toURI().toURL();
                name1 = name1.replace("\\", ".");
                classLoader = new URLClassLoader(new URL[]{url});
                Class.forName(name1, true, classLoader);
                temp = Class.forName(name1, true, classLoader);
            } catch (ClassNotFoundException | MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (temp != null) {
            printClassDetails(temp);
            invokeMethods(temp);
        }

    }

    public void loadPath(File executedFile) {
        if (executedFile == null) {
            Scanner pathScanner = new Scanner(System.in);
            System.out.println("Give the full path for the directory/file you want to execute");
            String classPath = pathScanner.nextLine();
            File file = new File(classPath);

            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        for (File newFile : Objects.requireNonNull(file.listFiles())) {
                            loadPath(newFile);
                        }
                    }
                } else {
                    if (file.getName().endsWith(".class")) {
                        URL url = file.getAbsoluteFile().getParentFile().toURI().toURL();
                        String className = file.getName().split("\\.")[0];
                        URLClassLoader cl = URLClassLoader.newInstance(new URL[]{url});
                        loadClass(className, cl, file);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (executedFile.getName().endsWith(".class")) {
                    URL url = executedFile.getAbsoluteFile().getParentFile().toURI().toURL();
                    String className = executedFile.getName().split("\\.")[0];
                    URLClassLoader cl = URLClassLoader.newInstance(new URL[]{url});
                    loadClass(className, cl, executedFile);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void printClassDetails(Class<?> appliedClass) {
        String className = appliedClass.getName();
        String packageName = appliedClass.getPackage().toString();

        System.out.println("\nWe used the class with the name " + className
                + " found in " + packageName + "\n\nThis class has the following fields: ");

        Field[] fields = appliedClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("--- " + field.getName());
        }

        System.out.println("\nThis class has the following declared methods:");

        Method[] methods = appliedClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("--- " + method.getName()
                    + " that is annotated with: " + Arrays.toString(method.getDeclaredAnnotations()));
        }
    }

    private void invokeMethods(Class<?> appliedClass) {
        {
            Method[] methods = appliedClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    Class<?>[] parameters = method.getParameterTypes();
                    Object[] objects = new Object[parameters.length];
                    int i = 0;
                    for (Class<?> parameter : parameters) {
                        if (parameter.equals(int.class)) {
                            objects[i] = (int) (Math.random() * 100);
                            i++;
                        }
                        if (parameter.equals(String.class)) {
                            objects[i] = "string";
                            i++;
                        }
                        if (!parameter.equals(int.class) && !parameter.equals(String.class))
                            break;
                    }
                    if (i != parameters.length)
                        continue;
                    try {
                        int modifiers = appliedClass.getModifiers();
                        if (Modifier.isStatic(modifiers)) {
                            totalTests++;
                            System.out.println("Running " + method.getName() + "...");
                            method.invoke(objects);
                            passedTests++;
                        } else {
                            totalTests++;
                            System.out.println("Running " + method.getName() + "...");
                            method.invoke(appliedClass.newInstance(), objects);
                            passedTests++;
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        System.out.printf("Test %s failed: %s %n", method, e.getCause());
                        failedTests++;
                    }
                }
            }
        }
    }

    public void printStats() {
        System.out.println("\nIn the end, the statistics look something like this...");
        System.out.println("---Total tests: " + totalTests);
        System.out.println("---Tests passed: " + passedTests);
        System.out.println("---Tests failed: " + failedTests);
    }
}
