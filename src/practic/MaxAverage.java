package practic;

public class MaxAverage {
    // Найти подмассив содержащий максимальное среднее значение из чисел подмассива. Размер подмассива в переменной к.
    // nums = [1,12,-5,-6,50,3], k=4
    // 12,-5,-6,50 =12.75
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        int sum = 0;
        double maxAvg;


        for (int i = 0; i < (nums.length - k); i++) {
            int sum1 = 0;
            for (int j = i; j < (i + k); j++) {
                sum1 += nums[j];
            }

            if (sum1 > sum) {
                sum = sum1;
            }
        }
        maxAvg = (double) sum / k;
        System.out.println("maxAvg = " + maxAvg);
    }
}
