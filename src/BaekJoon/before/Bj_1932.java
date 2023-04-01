import java.util.Scanner;
//정수삼각형
public class BJ_1932 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            int[][] arr = new int[num][num];

            // 배열초기화
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < i + 1; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            //맨 아래부터 나와 오른쪽 값 중에 큰 값과 위에 값 더하기 -> 반복하면 0,0에 최댓값 들어옴
            for (int i = num - 1; i > 0; i--) {
                for (int j = 0; j < i; j++)
                    arr[i-1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }

            System.out.println(arr[0][0]);

        }
}
