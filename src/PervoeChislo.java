import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PervoeChislo {


    public static void main(String[] args) {

        int[] mas = {7,1, 5, 3};
        Arrays.sort(mas);

        int min = mas[0];

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min){
                min = mas[i];
            }

        }
        System.out.println("min = " + min);


    }
}
