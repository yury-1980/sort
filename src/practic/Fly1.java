package practic;

public class Fly1 {

    public static void main(String[] args) {
        Fly fly = new Fly();
        Thread thread = new Thread(fly);
        thread.start();
        thread.getState();


        String input = "ABC123XYZ789PQR";
        String pattern = "^\\d{2}$";

        boolean matches = input.matches(pattern);

        if (matches) {
            System.out.println("Совпадает!");
        } else {
            System.out.println("Не совпадает.");
        }
    }
}
