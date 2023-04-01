import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        double sum = 0;
        double tmp = 0;
        int[] numbers = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = 0;

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (numbers[i] > max)
                max = numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                tmp =0;
            }
            else{
            tmp = ((double)numbers[i] / max) * 100;
            }
            sum = sum + tmp;

        }
        System.out.println(sum / numbers.length);

    }
}