package practic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMyAll {

    public static void main(String[] args) throws InterruptedException {
        ThreadMy threadMy = new ThreadMy();
        threadMy.start();
//        threadMy.start();
        System.out.println("threadMy.getState() = " + threadMy.getState());// происходит раньше join
        threadMy.join();
        System.out.println("threadMy.getName() = " + threadMy.getName());
//-----------------------------
        Thread thread = new Thread(() -> {
            System.out.println("Поток выполняется");
        });

        thread.start(); // Успешный запуск
        try {
            thread.start(); // Попытка повторного запуска
        } catch (IllegalThreadStateException e) {
            System.out.println("Ошибка: Поток нельзя запустить повторно");
        }
//--------------------
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> System.out.println("Выполнение задачи в пуле потоков");
        executor.submit(task);

        executor.shutdown();
    }
}

class CallableMy implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "CallableMy";
    }
}

class ThreadMy extends Thread {

    @Override
    public void run() {
//        super.start();
        System.out.println("Меня зовут: " + getName());
    }
}

class RunnableMy implements Runnable {

    @Override
    public void run() {

    }
}