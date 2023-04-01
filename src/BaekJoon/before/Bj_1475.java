import java.util.*;
public class boj_1475 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int num; // 각 자리수

        int  max=0;
        int []a = new int [10];
        for(int i=0; i<a.length; i++)
        {a[i] = 0;}

        while (N!=0)
        {
            num=N%10;
            a[num]+=1;
            N/=10;
        }
        //짝홀, 홀짝
        if((a[6]%2==0 && a[9]%2!=0)||(a[6]%2!=0 && a[9]%2==0))
        {
            a[6] = (a[6]+a[9]+1)/2;
            a[9] =0;
        }
        // 홀홀, 짝짝
        else{
            a[6]=(a[6]+a[9])/2;
            a[9]=0;

        }


        for(int i=0; i<a.length; i++)
        {
            if(a[i]>max)
            {max =a[i]; }
        }

        System.out.println(max);
    }
}
