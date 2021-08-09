import java.util.Scanner;
public class RectangularStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=1; i<=m; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
