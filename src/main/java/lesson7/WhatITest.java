package lesson7;

import java.util.ArrayList;

public class WhatITest {
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
        int [] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i ++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
