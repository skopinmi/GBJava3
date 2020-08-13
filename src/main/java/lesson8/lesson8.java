package lesson8;
import java.util.Arrays;

public class lesson8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countNumbersInArray(new int[]{1, 2, 3, 2, 3, 1, 1, 1, 1, 3}, 3)));
/*
    чмассив из строки
 */
        String arr = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5 " +
                "4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3 " +
                "1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3 " +
                "2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5 " +
                "2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5 " +
                "3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1 " +
                "5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4";
        String[] array = arr.split(" ");
        int [] a = new int[array.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(array[i]);
        }
        System.out.println(Arrays.toString(countNumbersInArray(a, 5)));
    }
/*
    метод параметры массив и количество схожих элементов (цифр)
 */
    public static int [] countNumbersInArray (int [] array, int n) {
        int [] result = new int[n];
        for (int a: array) {
            for (int i = 0; i < result.length; i++) {
                if (a == i+1) {
                    result[i]++;
                    break;
                }
            }
        }
        return result;
    }
}
