import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Mediana {

    public static void main(String[] args) {
        int[] nums1 = {5,4,8,2};
        int[] nums2 = {8, 5, 6, 7, 1};
        Arrays.stream(findMedianSortedArrays(nums1, nums2)).forEach(System.out::print);
    }
    public static int[] findMedianSortedArrays(int[] nums1, int[] nums2) {

//        List<Integer> result = new ArrayList<>();

        int[] result = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2))
                .sorted()
                .toArray();
            return result;
    }
}
