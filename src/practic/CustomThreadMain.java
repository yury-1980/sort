package practic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomThreadMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CallableMy callableMy = new CallableMy();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> result = executor.submit(callableMy);
        System.out.println("result = " + result.get());

        for (int i = 0; i < 5; i++) {
            final int value = i;
            executor.submit(() -> System.out.println(value));
        }
        executor.shutdown();

        Thread.sleep(1000);

        Thread thread = new CustomThread();
        System.out.println("thread.getState() = " + thread.getState());
        thread.run();
        thread.start();
        System.out.println("thread.getState() = " + thread.getState());
        Thread.sleep(500);
        System.out.println("thread.getState() = " + thread.getState());
        thread.run();
        thread.join();
        thread.start(); // IllegalThreadStateException
        // Что напечатается? Поток можно вызвать только 1 раз!
    }
}
