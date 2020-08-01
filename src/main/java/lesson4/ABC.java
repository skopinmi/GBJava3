package lesson4;

public class ABC {
    private static int count = 1;

    public static void main(String[] args) {
        Printer printer = new Printer();
        ThreadABC threadA = new ThreadABC(printer, "A", 1);
        ThreadABC threadB = new ThreadABC(printer, "B", 2);
        ThreadABC threadC = new ThreadABC(printer, "C", 3);
        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();
    }
}
class Printer {
    private static int count = 1;
    public synchronized void printABC (String a, int b) {
        for (int i = 0; i < 5; i++) {
            while (count != b) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(a);
            count += 1;
            if (count > 3) count = 1;
            notifyAll();
        }

    }
}
class ThreadABC implements Runnable {

    Printer printer;
    String msg;
    int a;

    public ThreadABC(Printer printer, String msg, int a) {
        this.printer = printer;
        this.msg = msg;
        this.a = a;
    }

    @Override
    public void run() {
        printer.printABC(msg, a);
    }
}