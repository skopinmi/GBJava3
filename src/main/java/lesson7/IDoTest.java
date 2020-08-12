package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class IDoTest {
    private Method[] methods;
    private Class cl;
    public static void start( Class a)  {
        Class cl = a;
        TestClass testClass = new TestClass();
        Method[] methods = a.getDeclaredMethods();
        Method[] arrayForStart = sortMethods(methods);
        for (Method o : arrayForStart) {
            try {
                o.invoke(testClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    public static Method[] sortMethods (Method [] arrayMethods) {
        Method [] result = new Method[arrayMethods.length];
        Method [] temp = new Method[arrayMethods.length];
        Method start = null;
        Method end = null;
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if(arrayMethods[i].isAnnotationPresent(AfterSuite.class)) {
                if (start != null) throw new RuntimeException();
                start = arrayMethods[i];
            } else if (arrayMethods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (end != null) throw new RuntimeException();
                end = arrayMethods[i];
            } else if (arrayMethods[i].isAnnotationPresent(Test.class)) {
                result[count] = arrayMethods[i];
            }
            count++;
        }
        temp = new Method[count];
        for(int i = 0; i < count; i++) {
            temp[i] = result [i];
        }
        for (int i = temp.length - 1; i <= 1 ; i--) {
            for (int ii = 0; ii < i ; ii++) {
                int a = temp[ii].getAnnotation(Test.class).priotity();
                int b = temp[ii + 1].getAnnotation(Test.class).priotity();
                if( a < b ) {
                    Method tempM = temp[ii];
                    temp[ii] = temp[ii + 1];
                    temp[ii + 1 ] = tempM;
                }
            }
        }
        count = 0;
        for (int i = 0; i < result.length; i++) {
            if (start != null) {
                result[i] = start;
                start = null;
            } else if (end != null && i == result.length - 1) {
                result[i] = end;
                end = null;
            } else {
                result[i] = temp[count];
                count++;
            }
        }
        return result;
    }


    public static void main(String[] args)  {
        Class ch = null;
        try {
            ch = ClassLoader.getSystemClassLoader().loadClass("lesson7.TestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        start(ch);
    }

}
