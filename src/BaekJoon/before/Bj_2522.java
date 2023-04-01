import java.util.*;
public class Boj_2522 {
    public static void main(String[] args) {
        int N = 0;
        Scanner in = new Scanner(System.in);
        N=in.nextInt();
        for(int i=N; i>0; i--)
        {

            System.out.println(" ".repeat(i-1)+"*".repeat(N-i+1));
        }
        for(int i=0; i<N-1; i++)
        {

            System.out.println(" ".repeat(i+1)+"*".repeat(N-i-1));
        }
    }


}
