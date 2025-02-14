package practic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Как запомнил условие: Есть кол-во отлетов, каждый отлет не сходит с дистанции, после очередного подхода если он не взял,
 * но вес ему не увеличивают, после 3-х подходов выбирается победитель с максимальным весом.
 */
public class MultiPractical {

    public static final CyclicBarrier BARRIER = new CyclicBarrier(4, System.out::println);
    public static final CyclicBarrier FINISH = new CyclicBarrier(4, () -> {
        if (Athletic.weightMax > 0) {
            System.out.println("Максимальный вес = " + Athletic.weightMax + " Имя атлета = " + Athletic.nameMax);
        }
    });

    public static void main(String[] args) {
        List<Athletic> athletics = new ArrayList<>(List.of(
                new Athletic("a", 100),
                new Athletic("b", 110),
                new Athletic("c", 111),
                new Athletic("d", 120)));

        for (Athletic athletic : athletics) {
            new Thread(athletic).start();
        }
    }

    static class Athletic implements Runnable {

        private static volatile int weightMax;
        private static volatile String nameMax;
        private final String name;
        private int weight;

        public Athletic(String name, Integer weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {

                if (weight % 2 == 0) {
                    System.out.printf("Спортсмен %s вес на штанге %d взял!\n", name, weight);
                    weight *= 1.1;
                } else {
                    System.out.printf("Спортсмен %s вес на штанге %d не взял!\n", name, weight);
                }

                try {
                    BARRIER.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                if (weight > weightMax) {
                    weightMax = weight;
                    nameMax = name;
                }
            }

            try {
                FINISH.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}