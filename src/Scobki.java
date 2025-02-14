import java.util.Stack;

public class Scobki {

    public static void main(String[] args) {
        System.out.println(checkString("((()))")); // true
        System.out.println(checkString("((()()))")); // true
        System.out.println(checkString("(()")); // false
        System.out.println(checkString("(()))")); // false
        System.out.println(checkString(")(")); // false
    }

    public static boolean checkString(String str) {
        Stack<Character> stack = new Stack<>();

//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//
//            if (ch == '(') {
//                stack.push(ch);
//            } else if (ch == ')') {
//                if (stack.isEmpty()) {
//                    return false; // нет соответствующей открывающей скобки
//                }
//                stack.pop(); // нашли пару для открывающей скобки
//            }
//        }
//
//        return stack.isEmpty(); // если стек пустой, все скобки закрыты правильно

//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < str.length(); i++) {
//
//            if (str.charAt(i) == '(') {
//                stack.push('(');
//            }
//
//            if (str.charAt(i) == ')') {
//                if (stack.isEmpty()) {
//                    return false;
//                } else {
//                    stack.pop();
//                }
//            }
//        }
//        return stack.isEmpty();

//        Stack<Character> stack = new Stack<>();
//
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

