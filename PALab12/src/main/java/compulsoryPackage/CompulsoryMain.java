package compulsoryPackage;

import java.lang.reflect.*;
import java.util.Arrays;

public class CompulsoryMain {
    public static void main(String[] args){
        Class<SomeClass> appliedClass = compulsoryPackage.SomeClass.class;

        String className = appliedClass.getName();
        String packageName = appliedClass.getPackage().toString();

        System.out.println("We used the class with the name " + className
                + " found in " + packageName + "\n\nThis class has the following fields: ");

        Field[] fields = appliedClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println("--- " + field.getName());
        }

        System.out.println("\nThis class has the following declared methods:");

        Method[] methods = appliedClass.getDeclaredMethods();
        for (Method method: methods){
            System.out.println("--- " + method.getName()
                    + " that is annotated with: " + Arrays.toString(method.getDeclaredAnnotations()));
        }
    }
}
