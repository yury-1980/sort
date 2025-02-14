public class Palindrom {

    public static void main(String[] args) {

        String str = "asd fgf ds:as";

        System.out.print(ravno(str));


        String s = "dsffdfdfd";
        String[] s1 = s.split("");
        for (String s2 : s1) {
            System.out.println(s2);
        }

    }

    static boolean ravno(String str) {

        int chLeft = 0;
        int chReght = str.length() - 1;;

        while (chLeft < chReght) {

            if (!Character.isLetterOrDigit(str.charAt(chLeft))) {
                chLeft++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(chReght))) {

                chReght--;
                continue;
            }

            if ((str.charAt(chLeft) != str.charAt(chReght))) {
                return false;
            }
            chLeft++;
            chReght--;
        }
        return true;
    }
}
