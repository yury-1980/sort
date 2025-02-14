package practic;

import java.util.Arrays;

public class StrokiNaPary {

    public static void main(String[] args) {
        String s = "abcdef1";
        System.out.println("solution(s) = " + Arrays.toString(solution(s)));
    }

    //Завершите решение так, чтобы строка разбивалась на пары по два символа. Если строка содержит нечетное количество
// символов, необходимо заменить отсутствующий второй символ последней пары подчеркиванием («_»). Примеры:
//* 'abc' =>  ['ab', 'c_']
//* 'abcdef' => ['ab', 'cd', 'ef']
    public static String[] solution(String s) {
        String[] strMas;
        int l = s.length();
        int y = 0;
        StringBuilder builder = new StringBuilder();

        if (l % 2 == 1) {
            l++;
            s += "_";
        }
        strMas = new String[(l / 2)];

        for (int i = 0; i < s.length(); i += 2) {
            builder.append(s.charAt(i)).append(s.charAt(i + 1));
            strMas[y] = builder.toString();
            builder.delete(0, 2);
            y++;
        }
        return strMas;
    }
}
