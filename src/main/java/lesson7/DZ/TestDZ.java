package lesson7.DZ;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class TestDZ {

    public static void main(String[] args) {
        String path = "src/main/java/lesson7/DZ/lesson1";
        File folder = new File(path);
        File[] files = folder.listFiles();
        HashMap<File, Method[]> dz = new HashMap<>();
        for (File a : files) {
            System.out.println(a.getName());
            dz.put(a, getMethodsFromFile(a, folder));
        }


    }
    public static Method[] getMethodsFromFile (File file, File folder) {
        Method[] methods = null;
        String[] tok = file.getName().split("\\.");
        Class ch = null;
        try {
            System.out.println(folder.toURL());
            ch = URLClassLoader.newInstance(new URL[]{folder.toURL()}).loadClass(tok[0]);
        } catch (ClassNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        methods = ch.getMethods();
        System.out.println("g");
        return methods;
    }
}