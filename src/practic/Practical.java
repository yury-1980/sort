package practic;

import java.util.ArrayList;
import java.util.List;

public class Practical {

    public static void main(String[] args) {
        List<Athletic0> athletics = new ArrayList<>(List.of(
                new Athletic0("a", 100),
                new Athletic0("b", 110),
                new Athletic0("c", 111),
                new Athletic0("d", 120)));

        for (Athletic0 athletic0 : athletics) {
            new Thread(athletic0).start();
        }
    }

}

class Athletic0 implements Runnable {

    public static volatile int ostatok;
    public static volatile int number = 4;
    private String name;
    private int weight;

    public Athletic0(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public synchronized void run() {
        ostatok = number;
        for (int i = 0; i < 3; i++) {
            if (weight % 2 == 0) {
                try {
                    System.out.printf("Спортсмен %s вес на штанге %d взял!", name, weight);
                    weight *= 1.1;
                    ostatok--;
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.printf("Спортсмен %s вес на штанге %d не взял!", name, weight);
                number--;
                break;
            }
            if (ostatok == 0) {
                notifyAll();
            }
        }
    }
}