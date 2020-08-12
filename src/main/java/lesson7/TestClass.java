package lesson7;


import java.util.Arrays;

public class TestClass {
    WhatITest whatITest = new WhatITest();


    @AfterSuite
    public void printStart() {
        System.out.println("Start");

    }

    @Test(priotity = 1)
    public void test1 () {
        int [] a = {4, 2, 3, 4, 5};
        int [] b = {4, 5};
        System.out.println(Arrays.equals(b, whatITest.arrayAfterFour(a)));
    }

    @Test(priotity = 9)
    public void test2 () {
        int [] a = {4, 2, 3, 1, 5};
        int [] b = {2, 3, 1, 5};
        System.out.println(Arrays.equals(b, whatITest.arrayAfterFour(a)));
    }

    @Test
    public void test3 () {
        int [] a = {1, 2, 4, 5, 1};
        int [] b = {5, 1};
        System.out.println(Arrays.equals(b, whatITest.arrayAfterFour(a)));
    }
    @BeforeSuite
    public void printEnd() {
        System.out.println("End");
    }
}
