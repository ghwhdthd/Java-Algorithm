import java.util.*;
public class boj_1946 {


    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {


        boj_1946 b = new boj_1946();// 객체 생성

        int T = in.nextInt();
        int res=0;

        for(int i=0; i<T;i++)
        {
            res=b.check(in.nextInt());
            System.out.println(res);

        }


    }
    public int check(int n)
    {
        int min = 100001;

        int N = n;
        int count=0;
        int [][] test = new int[N][2];
        for(int i=0; i<N; i++)
        {

            for(int j=0; j<2; j++)
            {
                test[i][j]=in.nextInt();
            }
        }

        Arrays.sort(test, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        //1 4
        //2 3
        //3 2
        //4 1
        //5 5

        for(int i =0; i <N; i++)
        {
            //System.out.println(test[i][0]);
            if(test[i][1] == 1)
            {
                count++;
                break;
            }
            if(test[i][1]<min)
            {
                count++;
            }
            if(test[i][1] < min)
            {
                min = test[i][1];
            }
        }
        return count;

    }
}
