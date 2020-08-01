package lesson4.MFU;

public class MFUtest {
    public static void main(String[] args) {
        MineMFUPrint print = new MineMFUPrint();
        MineMFUScan scan = new MineMFUScan();
        MineMFUCopy copy = new MineMFUCopy(print, scan);
        Worker w1 = new Worker(print, "print 1" );
        w1.start();
        Worker w2 = new Worker(print, "print 2");
        w2.start();
        Worker w3 = new Worker(print, "print 3");
        w3.start();
        Worker w4 = new Worker(scan, "scan 4");
        w4.start();
        Worker w5 = new Worker(scan, "scan 5");
        w5.start();
        Worker w6 = new Worker(copy, "copy 6");
        w6.start();
        Worker worker = new Worker(scan," sc");
        worker.start();
        Worker w7 = new Worker(print, "print 3");
        w7.start();
        Worker w8 = new Worker(scan, "scan 4");
        w8.start();
        Worker w9 = new Worker(scan, "scan 5");
        w9.start();
/*
    вечный таймер
 */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int count = 0;
//                while (true) {
//                    System.out.println(count++);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}
abstract class MineMFU {
    boolean free;
    public synchronized void work(String stringForWork) {}

    public synchronized boolean isFree() {
        return free;
    }

    public synchronized void setFree(boolean free) {
        this.free = free;
    }
}
class MineMFUPrint extends MineMFU {
//    boolean free = true;
    public MineMFUPrint() {
    }

    @Override
    public synchronized void work(String stringForPrint) {
        free = false;
        System.out.println("I'm printing " + stringForPrint );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        free = true;
    }
}

class MineMFUScan extends MineMFU {
//    boolean free = true;
    public MineMFUScan() {
    }

    @Override
    public synchronized void work(String stringForScan) {
        free = false;
        System.out.println("I'm scanning " + stringForScan );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        free = true;
    }
}
/*
       требует доработки...
 */

class MineMFUCopy extends MineMFU {
    MineMFUPrint print;
    MineMFUScan scan;

    public MineMFUCopy(MineMFUPrint print, MineMFUScan scan) {
        this.print = print;
        this.scan = scan;
    }

    @Override
    public synchronized boolean isFree() {
        return print.isFree() && scan.isFree();
    }

    @Override
    public synchronized void work(String stringForScan) {
        System.out.println("I'm copy!");
        scan.work(stringForScan);
        print.work(stringForScan);
    }
}
/*
    начинает копировать только когда сканер и принтер свободны
 */
class MineMFUCopy2 extends MineMFU {
    MineMFUPrint print;
    MineMFUScan scan;

    public MineMFUCopy2(MineMFUPrint print, MineMFUScan scan) {
        this.print = print;
        this.scan = scan;
    }

    @Override
    public synchronized boolean isFree() {
        return print.isFree() && scan.isFree();
    }

    @Override
    public synchronized void work(String stringForScan) {
        while (true) {
//            System.out.println(scan.isFree() + " " + print.isFree());
            if(isFree()){
                scan.setFree(false);
                print.setFree(false);
                System.out.println("I'm copy!");
                scan.work(stringForScan);
                print.work(stringForScan);
                break;
            }
        }

    }
}

class Worker extends Thread {

    MineMFU mineMFU;
    String what;

    public Worker( MineMFU mineMFU, String what) {
        this.mineMFU = mineMFU;
        this.what = what;
    }

    @Override
    public void run() {
        mineMFU.work(what);
    }
}

//class Worker extends Thread {
//
//    MineMFU mineMFU;
//    String what;
//
//    public Worker( MineMFU mineMFU, String what) {
//        this.mineMFU = mineMFU;
//        this.what = what;
//    }
//
//    @Override
//    public void run() {
//        while () {
//            wait();
//            if (mineMFU.isFree()){
//                mineMFU.setFree(false);
//                mineMFU.work(what);
//                break;
//            }
//        }
//    }
//}
/*
    идет работа...
 */
//class Worker extends Thread {
//
//    MineMFU mineMFU;
//    String what;
//
//    public Worker( MineMFU mineMFU, String what) {
//        this.mineMFU = mineMFU;
//        this.what = what;
//    }
//
//    @Override
//    public void run() {
//
//        synchronized (mineMFU) {
//            System.out.println(getName() + " занял " + mineMFU.getClass().getSimpleName());
//            mineMFU.work(what);
//            System.out.println(getName() + " освободил");
//        }
//    }
//}
