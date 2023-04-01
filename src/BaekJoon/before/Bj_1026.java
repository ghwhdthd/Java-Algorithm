import java.util.*;
public class boj_1026 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N;
        int a;
        int res=0;
        N= in.nextInt();
        int[] A = new int [N];
        int[] B = new int [N];


        // A배열에 차례대로 값을 넣기
        for(int i=0; i<N; i++)
        {
            A[i]=in.nextInt();
        }
        //B배열도 차례대로 값 넣기
        for(int i=0; i<N; i++)
        {
            B[i]=in.nextInt();
        }

        //둘 다 오름차순 sort
        Arrays.sort(A);
        Arrays.sort(B);
        //Arrays.sort(A,Collections.reverseOrder());

        //A배열의 가장 큰 값 * B배열의 가장 작은 값을 다 더하면 최솟값이니까
        //A배열은 맨 뒤부터 B배열은 맨 앞부터 서로 곱하고 더하기
        for(int i=0; i<N; i++)
        {
            a=A[N-i-1]*B[i];
            res = a + res;
        }

        System.out.println(res);


    }
}
