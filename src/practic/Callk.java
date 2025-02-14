package practic;

public class Callk {

    String str = "//+-";

    public void callk(String str) {
        String[] split = str.split("^(-?\\d+)(\\s*[\\+\\-\\*/]\\s*)(-?\\d+)$");
    }
}
