package practic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class IndexyChisel {
    // найти индексы 2-х чисел, сумма которых равна таргет
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = new int[2];
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();
//        IntStream.range(0, nums.length)
//                .forEach(a -> map.put(nums[a], a));

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                result[0] = map.get(x);
                result[1] = i;
                System.out.println("result = " + Arrays.toString(result));
            }
            map.put(nums[i], i);
        }


//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
    }
}
