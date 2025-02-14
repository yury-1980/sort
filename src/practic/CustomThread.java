package practic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}