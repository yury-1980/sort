package practic;

import java.util.Arrays;

public class MasPoKrugu {

    public static void main(String[] args) {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8};
        int chash0;
        int chash1;
        chash0 = mas[0];
        chash1 = mas[1];

        int a;
        int b;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    a = mas[j + 1];
                    mas[j + 1] = mas[j];
                    mas[j] = a;
                }
            }
        }
        System.out.println("masSort = " + Arrays.toString(mas));

//        for (int i = 0; i < mas.length; i += 2) {
            for (int j = 0; j < mas.length - 1; j += 2) {
                a = mas[j];
                mas[j] = mas[j + 1];
                mas[j + 1] = a;

            }

//        }
        System.out.println("masSort = " + Arrays.toString(mas));
    }
}
