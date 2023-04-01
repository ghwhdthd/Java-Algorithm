import java.util.*;

//바이러스
public class Boj_2606 {
    static boolean [] infected = new boolean[101]; // 방문여부 체크
    static boolean [] visited = new boolean[101]; // 방문여부 체크


    public static void check(int arr1, int arr2)
    {
        infected[arr1] = true;
        infected[arr2] = true;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int comCount = in.nextInt(); // 컴퓨터 개수
        int netCount = in.nextInt(); // 네트워크 쌍 개수

        Arrays.fill(infected,false); // infected 배열을 false로 초기화
        infected[1] = true; // 1번 컴퓨터는 무조건 바이러스 걸리니까 true

        int res = 0; // 결과변수

        int [][]arr = new int[netCount][2];

        //arr에 차례대로 값 넣기
        for(int i=0; i< arr.length; i++)
        {
            for(int j=0; j< arr[i].length;j++ )
            {
                arr[i][j]= in.nextInt();

            }
        }

        //1을 포함하고 있는 쌍은 infected true로 바꾸기

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                if(arr[i][j]==1)
                {
                    int arr1 = arr[i][0];
                    int arr2 = arr[i][1];
                    check(arr1,arr2);
                }
            }
        }

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length;j++)
            {
                int n = arr[i][j];
                if(n==1) continue;
                if(infected[n])
                {
                    int arr1 = arr[i][0];
                    int arr2 = arr[i][1];
                    check(arr1,arr2);
                }


            }
        }
        for(int i = 1; i<=comCount; i++)
        {
            if(infected[i])
            {res++;}
        }

        System.out.println(res-1); // 1번 컴퓨터는 빼고 계산해야하니까
    }
}
