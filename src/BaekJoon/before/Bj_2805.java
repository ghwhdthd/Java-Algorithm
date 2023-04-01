import java.util.Scanner;

public class Boj_2805 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int min = 0;
        int max = 0;
        int mid = 0;


        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
            max = Math.max(max,arr[i]);
        }


        while(min<max)
        {
            long tree=0;
            mid = (max + min)/2;
            for(int i = 0; i< n; i++)
            {
                if(arr[i] > mid)
                {
                    tree = tree + arr[i] - mid;
                }
            }

            if(tree >= m)
            {
                min = mid + 1;
            }
            else if(tree<m)
            {
                max = mid;
            }

        }

        System.out.println(min-1);

    }
}
