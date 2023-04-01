import java.util.*;

public class Boj_11723 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(N);
        int[] a;
        a = new int[21];
        String add = "add";
        String remove = "remove";
        String check = "check";
        String toggle = "toggle";
        String all = "all";
        String empty = "empty";


        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            System.out.println(str);
            if (all.equals(str))
            {

                for (int j = 1; j <= 20; j++)
                {
                    a[j] = 1;
                }

            }
            else if (empty.equals(str))
            {

                for (int j = 1; j <= 20; j++)
                {
                    a[j] = 0;
                }
            }
            else
            {
                String[] str2 = str.split("\\s");
                String func = str2[0];
                System.out.println(str2);
                //System.out.println(str2[1]);

                int num = 1;

                if (add.equals(func))
                {
                    if (a[num] == 0)
                    {
                        a[num] = 1;

                    }

                }
                else if (remove.equals(func))
                {
                    if (a[num] == 1)
                    {
                        a[num] = 0;

                    }

                }
                else if (check.equals(func))
                {
                    if (a[num] == 1) {
                        System.out.println(1);

                    } else {
                        System.out.println(0);
                    }
                } else if (toggle.equals(func)) {
                    if (a[num] == 1) {
                        a[num] = 0;

                    } else {
                        a[num] = 1;
                    }

                }
            }

        }
    }
}
