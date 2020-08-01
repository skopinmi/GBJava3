package lesson3;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> all = new ArrayList<>();
        all.add(new FileInputStream("src\\1"));
        all.add(new FileInputStream("src\\2"));
        all.add(new FileInputStream("src\\3"));
        all.add(new FileInputStream("src\\4"));
        all.add(new FileInputStream("src\\5"));
        writeFromManyFileToOneFile("src\\all", all);



//        writeFromFileToConsole("src\\1.txt");
    }

    public static void writeFromManyFileToOneFile(String oneFile, ArrayList<InputStream> all) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(oneFile, true);
        for (InputStream a: all) {
            int count;
            byte [] arr = new byte[100];
            while ((count = a.read(arr)) > 0) {
                for (int i = 0; i < count; i ++) {
                    fileOutputStream.write(arr[i]);
                }
            }
            a.close();
        }
        fileOutputStream.close();
    }
    public static void writeFromFileToConsole(String path) {
        try (FileInputStream in = new FileInputStream(path)) {
            int arrayLength = 50;
            byte[] arr = new byte[arrayLength];
            int oneByte;
            while ((oneByte = in.read(arr)) > 0) {
                for (byte a : arr) {
                    if(a == 0) {break;}
                    System.out.println(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
