
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ReadFilePages {

    private static int index;
    private static final int countCharsPerPages = 1800;
    private static boolean hasNextPage = true;
    private static String file = "src\\text";
    public static void main(String[] args) {
        System.out.println("Начало программы. Размер файла " + new File(file).length() + " байт.");
        long t = System.currentTimeMillis();
        index = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            int countOfPages = 1;
            while (hasNextPage) {
                long timeOnePage = System.currentTimeMillis();
                printPage(getOnePage(randomAccessFile, countCharsPerPages));
                System.out.println("Page №" + countOfPages);
                System.out.println("reading time " + (System.currentTimeMillis() - timeOnePage));
                countOfPages++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения программы " + (System.currentTimeMillis() - t));
    }
    public static int [] getOnePage (RandomAccessFile randomAccessFile, int countCharsPerPages) {
        int[] result = new int[countCharsPerPages];
        try {
            for (int i = 0; i < countCharsPerPages; i++){
               if (randomAccessFile.length() > index) {
                   randomAccessFile.seek(index);
                   result[i] = randomAccessFile.read();
                   index++;
               } else {
                   hasNextPage = false;
                   return result;
               }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void printPage (int [] array) {

        for(int a: array) {
            System.out.print((char) a);
        }
        System.out.println("");
    }
}
