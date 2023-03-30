package day_0330.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2239_송종호 {

	static int[][] input = new int[9][9];
	//static int[] candidate= new  int[9];
	static List<Integer> candidate = new LinkedList<>(); 
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			String tmp = br.readLine();
			for(int j=0; j<9; j++) {
				input[i][j]=tmp.charAt(j)-'0';
			}
		}
		
		//입력 끝
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				for(int k=0; k<9; k++) {
					candidate.add(k+1); // 1,2,3,4,5,6,7,8,9
				}
				if(input[i][j] == 0) {
					garo(i);
					sero(j);
					nemo(i,j);
					
				}
			}
		}
		
	}
	private static void garo(int r) {
		for(int i=0; i<9; i++) {
			if(input[r][i] == 0) continue;
			for(int j=0; j<candidate.size(); j++) {
				if(input[r][i] == candidate.get(j)) {
					candidate.remove(j);
					j--;
				}
				//가로 조사했는데 후보가 될 수 없으면 삭제해				
			}
		}
		
		
	}
	private static void sero(int c) {
		for(int i=0; i<9; i++) {
			if(input[i][c] == 0) continue;
			for(int j=0; j<candidate.size(); j++) {
				if(input[i][c] == candidate.get(j)) {
					candidate.remove(j);
					j--;
				}
				//세로 조사했는데 후보가 될 수 없으면 삭제해				
			}
		}
		
	}
	private static void nemo(int r, int c) {
		
		
	}
	
}
