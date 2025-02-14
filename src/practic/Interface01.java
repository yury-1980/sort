package practic;

//@FunctionalInterface
public interface Interface01 extends Interface02, Interface03 {

    void a();

    @Override
    void b();

    @Override
    default void c() {
    }

    static void d() {

    }
}

interface Interface02 {

    void b();
}

interface Interface03 {
    void c();
}