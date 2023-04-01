import java.util.*;

//다리 놓기

// nCr = n-1Cr-1 + n-1Cr 성질 활용

public class Boj_1010 {

    static int [][] combi = new int[30][30]; // N,M <= 30

    public static void main(String[] args) {

        int n,r; // M == n, N == r
        Scanner in = new Scanner(System.in);

        int count = in.nextInt(); // 케이스 몇개인지

        for(int i = 0; i<count; i++)
        {
            r= in.nextInt();
            n= in.nextInt();

            System.out.println(combination(n,r));
        }

    }
    private static int combination(int n, int r)
    {
        // 예전에 풀었던 거는 바로 반환
        if(combi[n][r] >0)
        {
            return combi[n][r];
        }

        if(n==r || r==0)
        {
            return combi[n][r] =1;
        }
        else{
            return combi[n][r]=combination(n-1,r-1) + combination(n-1,r);
        }

    }
}
