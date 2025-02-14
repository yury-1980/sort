import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Foreach {

    public static void main(String[] args) {

//        arr.removeIf(a -> a > 100);

//        arr.removeIf(a -> a > 50);

//        for (int i = 0; i < arr.size(); i++) {
//            arr.remove(0);
//        }

//        arr.add(15);

//        arr.remove(1); // Проверить - что после объявления итератора коллекцию изменять нельзя. Да
        List<Integer> arr = new ArrayList<>(List.of(120, 410, 85, 32, 314, 12));
        Iterator<Integer> it = arr.iterator();

        while (it.hasNext()) {
            if (it.next() % 10 == 0) {
                it.remove();
            }
        }


//        Iterator<Integer> iterator = arr.iterator();
//
//        while (iterator.hasNext()) {
//            if (iterator.next() > 100) {
//                iterator.remove();
//            }
//        }

//        for (int x : arr) {
//            if (x < 100) {
//                arr.remove(x);
//            }
//        }
        System.out.print("arr = " + arr + " ");

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Stream<Integer> stream = list.stream();

        list.add(4); // Изменение источника данных
        stream.forEach(System.out::println); // Может выбросить ConcurrentModificationException

    }
}
