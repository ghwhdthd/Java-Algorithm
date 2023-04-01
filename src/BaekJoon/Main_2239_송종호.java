package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2239_송종호 {

	static int[][] input = new int[9][9];
	//static int[] candidate= new  int[9];
	static List<Integer> candidate;
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
				if(input[i][j] != 0)continue;
				candidate = new LinkedList<>();
				for(int k=0; k<9; k++) {
					candidate.add(k+1); // 1,2,3,4,5,6,7,8,9
				}
				if(input[i][j] == 0) {
					garo(i);
					sero(j);
					nemo(i,j);
					if(candidate.size() == 0) continue;
					input[i][j] = candidate.get(0);
				}
			}
		}

		for(int i =0; i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print(input[i][j]);
			}
			System.out.println();
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
		if(r<=2){
			if(c<=2){
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if(input[i][j] != 0) {
							for(int k=0; k<candidate.size(); k++){
								if(input[i][j] == candidate.get(k)){
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=3 && c<=5){
				for(int i=0; i<3; i++){
					for(int j=3; j<6; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=6){
				for(int i=0; i<3; i++){
					for(int j=6; j<9; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}
		}
		else if(r>=3 && r<=5){
			if(c<=2){
				for(int i=3; i<6; i++){
					for(int j=0; j<3; j++){
						if(input[i][j] != 0) {
							for(int k=0; k<candidate.size(); k++){
								if(input[i][j] == candidate.get(k)){
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=3 && c<=5){

				for(int i=3; i<6; i++){
					for(int j=3; j<6; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=6){
				for(int i=3; i<6; i++){
					for(int j=6; j<9; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}
		}
		else if(r>=6){
			if(c<=2){
				for(int i=6; i<9; i++){
					for(int j=0; j<3; j++){
						if(input[i][j] != 0) {
							for(int k=0; k<candidate.size(); k++){
								if(input[i][j] == candidate.get(k)){
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=3 && c<=5){
				for(int i=6; i<9; i++){
					for(int j=3; j<6; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}

			else if(c>=6){
				for(int i=6; i<9; i++){
					for(int j=6; j<9; j++){
						if(input[i][j] != 0) {
							for (int k = 0; k < candidate.size(); k++) {
								if (input[i][j] == candidate.get(k)) {
									candidate.remove(k);
									k--;
								}
							}
						}
					}
				}
			}
		}
	}
}
