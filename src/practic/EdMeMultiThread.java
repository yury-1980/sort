package practic;

public class EdMeMultiThread {

    static volatile int a;
    static Object lock = new Object();


    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter(10); // Максимальное число 10

        Thread oddThread = new Thread(() -> printer.printOdd(), "Нечётный поток");
        Thread evenThread = new Thread(() -> printer.printEven(), "Чётный поток");

        oddThread.start();
        evenThread.start();
    }
}

class NumberPrinter {
    private final int max; // Максимальное число для вывода
    private int current = 1; // Текущее число
    private final Object monitor = new Object(); // Монитор для синхронизации

    public NumberPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (monitor) {
            while (current <= max) {
                if (current % 2 == 0) { // Ждём, если текущее число чётное
                    try {
                        monitor.wait(); // Освобождаем монитор и ждём
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + current);
                    current++;
                    monitor.notify(); // Уведомляем второй поток
                }
            }
        }
    }

    public void printEven() {
        synchronized (monitor) {
            while (current <= max) {
                if (current % 2 != 0) { // Ждём, если текущее число нечётное
                    try {
                        monitor.wait(); // Освобождаем монитор и ждём
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + current);
                    current++;
                    monitor.notify(); // Уведомляем первый поток
                }
            }
        }
    }
}
