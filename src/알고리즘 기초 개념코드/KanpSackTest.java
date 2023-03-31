package day_0330.live;

import java.util.Scanner;

public class KanpSackTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();// 가방의 실제 무게
		
		//N개 물건의 무게와 가치를 입력받을 배열
		int[] weights = new int[N+1];
		int[] profits = new int[N+1]; 
		
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int [][] dpTable =  new int [N+1][W+1];
		//초기값 세팅 : int[][] 배열릐 자동 초기화를 이용 -> static일때만 되는거 아니였음?
		
		
		for (int i = 1; i <=N; i++) { //i : 물건
			for(int w=1; w<=W; w++) { // w :임시 가방의 무게
				// i번째 물건의 무게가 w를 초과하는지 확인 
				if(weights[i] > w) dpTable[i][w] = dpTable[i-1][w];
				else if(weights[i] <= w) {
					dpTable[i][w] = Math.max(profits[i] + dpTable[i-1][w - weights[i]],dpTable[i-1][w]);
				}
			}
			
		}
		
		
		System.out.println(dpTable[N][W]);
		
	}
}
/*
4
10
5 10
4 40
6 30
3 50

==> 90

4 
16
2 40
5 30
10 50
5 10

==> 90

5 675
331 4015
120 8001
265 9209
13 6705
359 809

==> 23915

*/