package lesson6;

import java.util.ArrayList;

public class ArrayFromArray {
    public boolean hasOneAndFour (int [] array) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int a : array) {
            if (a != 1 && a != 4) return false;
            if (a == 1) hasOne = true;
            if (a == 4) hasFour = true;
        }
        return hasOne == hasFour;
    }

    public int [] arrayAfterFour (int [] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean hasFour = false;
        for (int a: array) {
            arrayList.add(a);
            if (a == 4) {
                hasFour = true;
                arrayList.clear();
            }
        }
        if (!hasFour) throw new RuntimeException();
        int [] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i ++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
