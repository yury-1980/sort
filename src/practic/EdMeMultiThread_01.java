package practic;

public class EdMeMultiThread_01 {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread odd = new Thread(() -> printer.getOdd(), "odd");
        Thread even = new Thread(() -> printer.getEven(), "even");
        odd.start();
        even.start();
        even.notify();
    }
}

class Printer {
    volatile int i = 1;
//    boolean isEven = false; // Чётное?

    public synchronized void getEven() { // Чётное
//        for (int i = 1; i <= 10; i++) {

        while (i <= 10) {
            if (i % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(i + " - чётное число");
                notify();
                i++;
            }
//            isEven = false;
        }
    }

    public synchronized void getOdd() { // Нечётное
//            for (int i = 1; i <= 10; i++) {
        while (i <= 10) {
            if (i % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(i + " - нечётное число");
                i++;
                notify();
            }
//                isEven = true;
        }
    }
}
