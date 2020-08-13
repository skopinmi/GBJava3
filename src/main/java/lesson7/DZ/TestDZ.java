package lesson7.DZ;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class TestDZ {

    public static void main(String[] args) {
        Class ch = null;
        Constructor constructor = null;
        try {
            URL[] url = new URL[]{new File("D:/lesson1").toURL()};
            ch = URLClassLoader.newInstance(url).loadClass("lesson1");
        } catch (ClassNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            constructor = ch.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object l = constructor;

        Method[] methods = ch.getDeclaredMethods();
        for (Method a: methods) {
            if (!a.getReturnType().equals("void")) {
                try {
                    a.invoke(l);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }
/*
      создает HashMap<File, Method[]> имя файла и маасив всех его методов...
 */
//    public static HashMap<File, Method[]> makeMap (File folder) {
//        String path = "src/main/java/lesson7/DZ/lesson1";
//        File folder = new File(path);
//        File[] files = folder.listFiles();
//        HashMap<File, Method[]> dz = new HashMap<>();
//        for (File a : files) {
//            System.out.println(a.getName());
//            dz.put(a, getMethodsFromFile(a, folder));
//        }
//        return null;
//    }

//    private static Method[] getMethodsFromFile (File file, File folder) {
//        Method[] methods = null;
//        String[] tok = file.getName().split("\\.");
//        Class ch = null;
//        try {
//            System.out.println(folder.toURL());
//            ch = URLClassLoader.newInstance(new URL[]{folder.toURL()}).loadClass(tok[0]);
//        } catch (ClassNotFoundException | MalformedURLException e) {
//            e.printStackTrace();
//        }
//        methods = ch.getMethods();
//        System.out.println("g");
//        return methods;
//    }
}