package lesson5;

import java.util.Scanner;

public class ConsoleC {
    public static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        Addition add;
        add = (a, b) -> a + b;
        Subtraction sub;
        sub = (a, b) -> a - b;
        Division div;
        div = (a, b) -> a / b;
        Multiplication mult;
        mult = (a, b) -> a * b;

        System.out.println("Введите 2 числа:");
        System.out.println("первое число :");
        int a = sc.nextInt();
        System.out.println("второе число :");
        int b = sc.nextInt();
        System.out.println("Введите необходимое действие");
        System.out.println("+ , - , * , / ");
        String d;
        while (true) {
            d = sc.nextLine();
            if (!d.isEmpty()) {
                break;
            }
        }
        switch (d) {
            case "+" : {
                System.out.println(String.format("%s %s %s = ", a, d, b) + add.calculate(a, b));
                break;
            }
            case "-" : {
                System.out.println(String.format("%s %s %s = ", a, d, b) + sub.calculate(a, b));
                break;
            }
            case "/" : {
                System.out.println(String.format("%s %s %s = ", a, d, b) + div.calculate(a, b));
                break;
            }
            case "*" : {
                System.out.println(String.format("%s %s %s = ", a, d, b) + mult.calculate(a, b));
                break;
            }
            default:
                System.out.println(d);
        }
    }
    interface Addition {
        int calculate (int a, int b);
    }
    interface Subtraction {
        int calculate (int a, int b);
    }
    interface Division {
        int calculate (int a, int b);
    }
    interface Multiplication {
        int calculate (int a, int b);
    }
}
