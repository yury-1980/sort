package practic;

import java.util.ArrayList;
import java.util.List;

public class ExceptionProverka {

    public static void main(String[] args) {

        try {
            List<Integer> list = new ArrayList<>(Integer.MAX_VALUE);
        } catch (OutOfMemoryError error) {
//            error.printStackTrace();
            System.err.println("Кончился память!");
        } finally {
            System.err.println("Метод finally!");
        }
        System.err.println("end main");

//        try {
//
//            exception(5);
//        } catch (IndexOutOfBoundsException e) {
//            System.err.println("catch - из main");
//        }


    }

    static void exception(int a) throws IndexOutOfBoundsException, ArithmeticException {// Либо такое же, либо более широкое!
        try {
            if (5 == a) {

                throw new IndexOutOfBoundsException();
            }
            throw new ArithmeticException();

        } finally {
            System.err.println("Закрытие ресурсов");
        }

    }
}
