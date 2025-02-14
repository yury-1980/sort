package practic;

import java.util.*;
import java.util.concurrent.Callable;

public class DiamondProblem {
    public static void main(String[] args) {

        String s = "5";
        System.out.println("System.identityHashCode(s) = " + System.identityHashCode(s));
        PriorityQueue priorityQueue = new PriorityQueue();


        // Что вернёт put
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        System.out.println("integerStringHashMap.put(1-1, \"A\") = " + integerStringHashMap.put(1,  "A"));
        System.out.println("integerStringHashMap.put(1-2, \"B\") = " + integerStringHashMap.put(1,  "B"));
        System.out.println("integerStringHashMap.get(1) = " + integerStringHashMap.get(1));

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        new ArrayList<>();
        new LinkedList<>();
        new ArrayDeque<>();
//        Callable
        PriorityQueue<Object> objects = new PriorityQueue<>();

        HashSet<String> set = new HashSet<>();
        new LinkedHashMap<>();

        // Добавляем элементы
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Дубликат
        set.add("Date");
        set.add(null);

        // Вывод всех элементов
        System.out.println("Элементы в HashSet:");
        for (String item : set) {
            System.out.println(item);
        }


        C c = new C();
        c.show();

        Collection c1 = new HashSet();
        print(c1);
    }

    public static void print(Collection c) {
        System.out.println("Collection");
    }

    public static void print(Set s) {
        System.out.println("Set");
    }

    public static void print(HashSet h) {
        System.out.println("HashSet");
    }
}

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {
    // Разрешение конфликта
    @Override
    public void show() {
        A.super.show();  // Явно указываем, какой метод вызвать
    }
}
