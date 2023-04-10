package day_0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2383_송종호 {
	static int N;
	static final int M = 1, W = 2, D = 3, C = 4; // 이동중, 대기중, 내려가는중, 완료

	static class Person implements Comparable<Person> {
		int r, c, arrivalTime, downCnt, status;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void init() {
			arrivalTime = downCnt = 0;
			status = M;

		}

		public Person(int r, int c, int arrivalTime, int downCnt, int status) {
			super();
			this.r = r;
			this.c = c;
			this.arrivalTime = arrivalTime;
			this.downCnt = downCnt;
			this.status = status;
		}

		@Override
		public int compareTo(Person o) {

			return (this.arrivalTime - o.arrivalTime);
		}

	}

	static ArrayList<Person> pList;
	static int[][] sList;
	static int cnt;
	static int isSelected[];
	static PriorityQueue<Integer> pq ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>(); // 사람 리스트
			sList = new int[2][]; // 계단 리스트
			pq = new PriorityQueue<>();
			StringTokenizer st;
			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) {
						pList.add(new Person(i, j));
					} else if (c > 1) { // 계단
						sList[k] = new int[] { i, j, c };
						k++;
					}

				}
			}
			// 입력 끝
			cnt = pList.size();
			isSelected = new int[cnt];
			// 모든 사람에게 계단을 배정
			divide(0);
			System.out.println("#"+ t +" "+ pq.peek());
		}
	}

	static void divide(int depth) {
		if (depth == cnt) {
			pq.add(go());
			return;
		}
		// 계단 0선택
		isSelected[depth] = 0;
		divide(depth + 1);

		// 계단 1선택
		isSelected[depth] = 1;
		divide(depth + 1);
	}

	// 선택된 계단에 따라
	// 사람들의 리스트를 만들고
	// 내려가기 처리 후
	// 소요된 시간을 리턴
	static int go() {
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };

		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			p.init(); // 사람의 상태를 초기화 -> 이거 왜하는 거지?
			int no = isSelected[i];// 계단 번호
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);

		}
		int s1 = 0, s2 =0;
		if (list[0].size() > 0) {
			s1 = processDown(list[0], sList[0][2]);
		}

		if (list[1].size() > 0) {
			s2 = processDown(list[1], sList[1][2]);
		}
		return Math.max(s1, s2);
	}

	static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);// 계단 입구까지 도착하는 시간이 빠른 순으로 정렬
		int time = list.get(0).arrivalTime; // 먼저 도착한 사람의 시간부터 흘러가게 함
		int size = list.size();

		int ingCnt = 0, cCnt = 0; // 내려가는 사람 수, 완료 사람 수
		Person p = null;
		while (true) {
			for (int i = 0; i < size; i++) {
				p = list.get(i);
				// 다 내려간 상태면 컨티뉴
				if (p.status == C) {
					continue;
				} else if (p.arrivalTime == time) {
					p.status = W;
				} else if (p.status == W && ingCnt < 3) {
					p.status = D; // 내려가기 시작
					p.downCnt = 1; //
					ingCnt++;
				} else if (p.status == D) {
					if (p.downCnt == height) {
						p.status = C;
						ingCnt--;
						cCnt++;
					} else {
						p.downCnt++;
					}
				}
			}
			if (cCnt == size)
				break;
			time++;
		}

		return time;
	}
}
