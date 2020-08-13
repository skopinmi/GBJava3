package lesson8;

import java.util.Arrays;

public class lesson8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countNumbersInArray(new int[]{1, 2, 3, 2, 3, 1, 1, 1, 1, 3})));
    }

    public static int [] countNumbersInArray (int [] array) {
        int [] result = new int[array.length];
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
