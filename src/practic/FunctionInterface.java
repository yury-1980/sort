package practic;

@FunctionalInterface
public interface FunctionInterface { // Это всё относится и к обычному интерфейсу

    public void print00();

    private static String println01() { // Может быть и private и public
        return null;
    }

    static String println00() { // Может быть и private и public
        return null;
    }

    default String println02() { // Только public
        return null;
    }

    private String println03() {
        return null;
    }
}
