import java.util.Arrays;
import java.util.List;

public class Max {


    public static void main(String[] args) {
        int[] mas = {2,1,4,7,4,8,3,6,4,7};

        int min = 0;
        int max = 0;

        List<Integer> list = Arrays.stream(mas)
                .boxed()
                .toList();

        for(int i = 0; i < mas.length; i++) {
            if(mas[i] > max) {
                max = mas[i];
            }
        }

        for(int i = 1; i <= max + 1; i++) {
            if(!list.contains(i)) {
                min = i;
                break;
            }
        }
        System.out.println("min = " + min);
    }

}
