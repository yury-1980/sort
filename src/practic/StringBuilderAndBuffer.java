package practic;

public class StringBuilderAndBuffer {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            builder.append(i);
        }
        for (int i = 0; i < builder.length(); i++) {
            System.out.println(builder.charAt(i));
        }
        long endTimeMillis = System.currentTimeMillis();
        System.out.println("Длина = " + builder.length());
        System.out.println("ResultTimeMillis = " + (endTimeMillis - currentTimeMillis));
    }
}
