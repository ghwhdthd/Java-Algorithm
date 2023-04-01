import java.util.Scanner;
import java.util.Arrays;

//ATM 문제
//결과적으로 시간 합의 최솟값 구하는 거니까 시간배열(P)을 오름차순으로 정렬한 후에 해당 시간들을 알맞게 더하면 최솟값이 나온다.
public class BJ_11399 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] arr;
        arr= new int[num];

        int a=0;


        //배열 초기화
        for(int i =0; i<num; i++)
        {
            arr[i] = in.nextInt();
        }

        //시간 배열 오름차순 정렬
        Arrays.sort(arr);


        // 더하기
        for(int i = 1; i<=num; i++)
        {
            for(int j=0; j<i; j++ )
            {
                a += arr[j];

            }
        }
        System.out.println(a);
    }
}
