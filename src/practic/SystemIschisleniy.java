package practic;

public class SystemIschisleniy {

    public static void main(String[] args) {
        String string = Integer.toString(10, 2);
        System.out.println("string = " + string);

        int i = Integer.parseInt("1010", 2);
        System.out.println("int = " + i);

        float amount = 1.00000005F;
        float avalue = 0.00000004F;
        float result = amount - avalue;
        System.out.println(result);

//        double positive_infinity = 12.0 / 0;
//        System.out.println(positive_infinity);

        double positive_infinity = 12.0 / 0;
        double negative_infinity = -15.0 / 0;
        System.out.println(positive_infinity + negative_infinity);

        String costForPrint = "5$";
        System.out.println("Цена только для вас " +
                costForPrint.charAt(0) + getCurrencyName(costForPrint.charAt(1)));
        
        double a = 0.1;
        double b = 0.7;
        System.out.println(a + b);
        
        int z = 0;
        int z1 = ++z;
        System.out.println("z1 = " + z1);

        byte q1 = 5;
        short q2 = 2;
        int i1 = q1 + q2; // Автоматически приводит к - int
    }

    public static String getCurrencyName(char symbol) {
        if (symbol == '$') {
            return " долларов";
        } else {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }
}
