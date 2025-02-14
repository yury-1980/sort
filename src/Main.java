import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Main {

    public static void main(String[] args) {

        int totalQuantity = 0;
        double totalAmount = 0.0;

        for (String product : args) {
            String[] parts = product.split(",");
            if (parts.length != 3) {
                System.out.println("Некорректные данные для товара: " + product);
                continue;
            }

            String name = parts[0].trim();
            int quantity;
            double price;
            try {
                quantity = getPositiveInteger(parts[1].trim());
                price = getPositiveDouble(parts[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("Некорректные данные для товара: " + product);
                continue;
            }

            int productQuantity = quantity;
            double productAmount = quantity * price;

            System.out.printf("%s = %d\n", name, productQuantity);
            totalQuantity += productQuantity;
            totalAmount += productAmount;
        }

        System.out.printf("Общее количество = %d\nОбщая сумма = %.2f", totalQuantity, totalAmount);
    }

    private static int getPositiveInteger(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Math.max(Integer.parseInt(sb.toString()), 1);
    }

    private static double getPositiveDouble(String input) {
        StringBuilder sb = new StringBuilder();
        boolean hasDot = false;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '.' && !hasDot) {
                sb.append(c);
                hasDot = true;
            }
        }
        return Math.max(Double.parseDouble(sb.toString()), 0.01);
    }
}