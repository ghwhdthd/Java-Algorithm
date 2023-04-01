import java.io.*;
import java.util.Scanner;
import java.util.*;

//******중요중요****************
// nextInt는 숫자만 받아오고 개행문자는 받아오지 않기 때문에
// nextInt 다음에 바로 nextLine를 써야하는 경우는 개행문자가 nextLine로 들어가는 문제 생김.
// 그래서 nextLine으로 숫자 받고 Integer.parseInt로 바꿔서 입력 받기
//****************************
public class B_11723 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] a;
        a = new int[21];
        String add = "add";
        String remove = "remove";
        String check = "check";
        String toggle = "toggle";
        String all = "all";
        String empty = "empty";
        String A;
        String B;

        for (int i = 0; i < N; i++) {
            A = br.readLine();
            if (all.equals(A)) {

                for (int j = 1; j <= 20; j++) {
                    a[j] = 1;
                }

            } else if (empty.equals(A)) {

                for (int j = 1; j <= 20; j++) {
                    a[j] = 0;
                }
            } else {
                String[] strArr = A.split("\\s");
                A = strArr[0];
                B = strArr[1];

                int num = Integer.parseInt(B);

                if (add.equals(A)) {
                    if (a[num] == 0) {
                        a[num] = 1;

                    }

                } else if (remove.equals(A)) {
                    if (a[num] == 1) {
                        a[num] = 0;

                    }

                } else if (check.equals(A)) {
                    if (a[num] == 1) {
                        bw.write(String.valueOf(1)+"\n");

                    } else {
                        bw.write(String.valueOf(0)+"\n");
                    }
                } else if (toggle.equals(A)) {
                    if (a[num] == 1) {
                        a[num] = 0;

                    } else {
                        a[num] = 1;
                    }

                }
            }

        }
        bw.flush();
        br.close();
        bw.close();
    }
}

