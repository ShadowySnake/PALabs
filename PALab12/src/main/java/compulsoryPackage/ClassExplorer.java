package compulsoryPackage;

import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Scanner;

public class ClassExplorer {
    Class<?> appliedClass;

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

        appliedClass = temp;
    }

    public void loadPath() {
        Scanner pathScanner = new Scanner(System.in);
        System.out.println("Give the full path of your file:");
        String classPath = pathScanner.nextLine();
        File file = new File(classPath);

        try {
            if (file.getName().endsWith(".class")) {
                URL url = file.getAbsoluteFile().getParentFile().toURI().toURL();
                String className = file.getName().split("\\.")[0];
                URLClassLoader cl = URLClassLoader.newInstance(new URL[]{url});
                loadClass(className, cl, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printClassDetails() {
        String className = appliedClass.getName();
        String packageName = appliedClass.getPackage().toString();

        System.out.println("We used the class with the name " + className
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

    public void invokeMethods() {
        Method[] methods = appliedClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int modifiers = method.getModifiers();
                if (Modifier.isStatic(modifiers)) {
                    Parameter[] parameters = method.getParameters();
                    if (parameters.length == 0) {
                        try {
                            System.out.println("\nRunning " + method.getName() + "...");
                            method.invoke(null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            System.out.printf("Test %s failed: %s %n", method, e.getCause());
                        }
                    }
                }
            }
        }
    }
}
