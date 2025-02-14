import java.util.ArrayList;
import java.util.List;

public class Podstroka {

    public static void main(String[] args) {
        String string = "dvdf";
        System.out.println(lengthOfLongestSubstring(string));
    }

    public static int lengthOfLongestSubstring(String s) {

        List<Character> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                if (list.size() > result)
                result = list.size();
            } else {
                list.clear();
                i--;
                list.add(s.charAt(i));
            }
        }
        System.out.println("list = " + list);
        return result;
    }
}

