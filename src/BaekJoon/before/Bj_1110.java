import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Bj_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        int right =-1;
        int left =-1;
        int tmp =-1;
        int count =0;

        int[] arr = new int [2];
        int[] arr2 = new int [2];
        if(a < 10){
            left = 0;
            right = a;
        }
        else{
            left = a/10;
            right = a%10;
        }

        arr[0] = left;
        arr[1] = right;

        arr2[0] = left;
        arr2[1] = right;


        while(true){
            tmp = arr2[0] + arr2[1];
            tmp = tmp % 10;

            arr2[0] = arr2[1];
            arr2[1] = tmp;
            count++;
            if(arr[0] == arr2[0] && arr[1] == arr2[1]){
                break;
            }

        }
        System.out.println(count);


    }
}
