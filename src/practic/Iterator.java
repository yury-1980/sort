package practic;

import java.util.*;

public class Iterator {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        java.util.Iterator<Integer> iterator = list.iterator();
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        list.add(6);

        System.out.print(list);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        ArrayDeque<String> strings = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
            arrayList.add(i);
            linkedList.add(i);
            set.add(i);
        }

        long start = System.currentTimeMillis();
        boolean b = map.containsKey(999_999);
        long end = System.currentTimeMillis();
        System.out.println("Проверка по ключу: " + (end - start) + " " + b);

        long start2 = System.currentTimeMillis();
        boolean b1 = map.containsValue(999_999);
        long end2 = System.currentTimeMillis();
        System.out.println("Проверка по значению: " + (end2 - start2) + " " + b1);

        long start3 = System.currentTimeMillis();
        boolean arList = arrayList.contains(999_999);
        long end3 = System.currentTimeMillis();
        System.out.println("Проверка arrayList: " + (end3 - start3) + " " + arList);

        long start4 = System.currentTimeMillis();
        boolean linkList = linkedList.contains(999_999);
        long end4 = System.currentTimeMillis();
        System.out.println("Проверка linkedList: " + (end4 - start4) + " " + linkList);

        long start5 = System.currentTimeMillis();
        boolean setCont = set.contains(999_999);
        long end5 = System.currentTimeMillis();
        System.out.println("Проверка set: " + (end5 - start5) + " " + setCont);


//new HashSet<>().

//        System.out.println("KING".hashCode());
    }
}
