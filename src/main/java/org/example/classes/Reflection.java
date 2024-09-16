package org.example.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reflection {

    private static final Logger logger = LogManager.getLogger(Reflection.class);
    // Method to print information about fields, constructors, and methods of a class
    public static void printClassInfo(Class<?> myClass) {
        // Log the class name
        logger.info("Class Information:");
        logger.info("Class Name: {}", myClass.getName());
        logger.info("=======================================");
        // Call private methods to log fields, constructors, and methods
        printFields(myClass);
        printConstructors(myClass);
        printMethods(myClass);
    }

    // Private method to log information about the fields of the class
    private static void printFields(Class<?> myClass) {
        logger.info("Fields:");
        Field[] fields = myClass.getDeclaredFields();

        if (fields.length == 0) {
            logger.info("No fields found.");
        } else {
            for (Field field : fields) {
                logger.info("---------------------------------------");
                logger.info("Field Name: {}", field.getName());
                logger.info("Type: {}", field.getType().getName());
                logger.info("Modifiers: {}", Modifier.toString(field.getModifiers()));
            }
        }
        logger.info("=======================================");
    }

    // Private method to log information about the constructors of the class
    private static void printConstructors(Class<?> myClass) {
        logger.info("Constructors:");
        Constructor<?>[] constructors = myClass.getDeclaredConstructors();

        if (constructors.length == 0) {
            logger.info("No constructors found.");
        } else {
            for (Constructor<?> constructor : constructors) {
                StringBuilder constructorInfo = new StringBuilder("Constructor Name: ");
                constructorInfo.append(constructor.getName()).append("(");

                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    constructorInfo.append(parameterTypes[i].getName());
                    if (i < parameterTypes.length - 1) {
                        constructorInfo.append(", ");
                    }
                }
                constructorInfo.append(")");

                logger.info("---------------------------------------");
                logger.info(constructorInfo.toString());
                logger.info("Modifiers: {}", Modifier.toString(constructor.getModifiers()));
            }
        }
        logger.info("=======================================");
    }

    // Private method to log information about the methods of the class
    private static void printMethods(Class<?> myClass) {
        logger.info("Methods:");
        Method[] methods = myClass.getDeclaredMethods();

        if (methods.length == 0) {
            logger.info("No methods found.");
        } else {
            for (Method method : methods) {
                StringBuilder methodInfo = new StringBuilder("Method Name: ");
                methodInfo.append(method.getName()).append("(");

                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    methodInfo.append(parameterTypes[i].getName());
                    if (i < parameterTypes.length - 1) {
                        methodInfo.append(", ");
                    }
                }
                methodInfo.append(")");

                logger.info("---------------------------------------");
                logger.info(methodInfo.toString());
                logger.info("Return Type: {}", method.getReturnType().getName());
                logger.info("Modifiers: {}", Modifier.toString(method.getModifiers()));
            }
        }
        logger.info("=======================================");
    }

    // Method to create an instance of a class using a specific constructor
    public static Object createInstance(Class<?> myClass, Object... initArgs) throws Exception {
        // Crear una lista de tipos de parámetros
        Class<?>[] parameterTypes = new Class<?>[initArgs.length];
        for (int i = 0; i < initArgs.length; i++) {
            if (initArgs[i] instanceof Integer) {
                parameterTypes[i] = int.class;
            } else if (initArgs[i] instanceof String) {
                parameterTypes[i] = String.class;
            } else if (initArgs[i] instanceof Queue) {
                parameterTypes[i] = Queue.class;
            } else if (initArgs[i] instanceof Enum) {
                parameterTypes[i] = ((Enum<?>) initArgs[i]).getDeclaringClass();
            } else {
                parameterTypes[i] = initArgs[i].getClass();
            }
        }

        // Buscar el constructor
        Constructor<?> constructor = myClass.getConstructor(parameterTypes);
        return constructor.newInstance(initArgs);
    }


    // Method to invoke a method on an object using reflection
    public static void invokeMethod(Object obj, String methodName, Object... params) throws Exception {
        Class<?> myClass = obj.getClass();
        Method method = myClass.getMethod(methodName, getParameterTypes(params));
        method.invoke(obj, params);
    }

    // Private method to get parameter types from provided values
    private static Class<?>[] getParameterTypes(Object... params) {
        Class<?>[] types = new Class<?>[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
            if (types[i].isPrimitive()) {
                types[i] = getWrapperClass(types[i]);
            }
        }
        return types;
    }

    // Get the corresponding wrapper class for primitive types
    // Get the corresponding wrapper class for primitive types
    private static Class<?> getWrapperClass(Class<?> myClass) {
        if (myClass == int.class) return Integer.class;
        if (myClass == long.class) return Long.class;
        if (myClass == double.class) return Double.class;
        if (myClass == float.class) return Float.class;
        if (myClass == char.class) return Character.class;
        if (myClass == boolean.class) return Boolean.class;
        return myClass;
    }


}