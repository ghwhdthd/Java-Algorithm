import java.util.*;

public class Boj_1120 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String A;
        String B;
        A = in.nextLine();
        String[] strArr = A.split("\\s");
        A = strArr[0];
        B = strArr[1];

        int b = 0;
        int min = 50;

        b = B.length() - A.length() + 1;

        for (int j = 0; j < b; j++) {
            int check = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(j + i)) {
                    check++;
                }
            }
            if (min > check) {
                min = check;
            }
        }

        System.out.println(min);


    }
}
