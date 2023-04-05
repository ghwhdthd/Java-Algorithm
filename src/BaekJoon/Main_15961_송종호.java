package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_15961_송종호 {
    static int N, d, k, c;
    //먼저 최댓값 다 계산하는데
    // 범위를 할당해서 set에 넣고
    // set size로  최댓값 계산하고
    // set에 넣으면서 쿠폰번호랑 일치하는게 있으면 true 체크
    // false이면 size + 1로
    // 만약에 최대값 == k+1 인 경우 break; 바로 출력 <- 이거보다 더 커질 수 없음
    // -> 이렇게 했는데 시간초과 났음.

    // 그래서 바꾼 풀이
    // for문 한번만 돌아야함
    // Linkedlist 와 해당 숫자가 몇개 들어갔는지 확인하는 checkList를 활용했음.
    // i < k 일때 까지는 li.add 를 수행하면서 중복되지 않은 새로운 숫자인 경우 cnt++
    // i >= k 부터는 li.remove(0) :  list 첫번째 값을 제거하고, 새로운 값을 li.add 한다.

    static int[] input;
    static int max = Integer.MIN_VALUE;
    static int[] checkList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new int[N+k-1];
        checkList = new int[d + 1];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N; i< input.length; i++){
            input[i] = input[i-N];
        }
        //input 끝

        List<Integer> li = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                int tmp = input[i];
                li.add(tmp);
                if (checkList[tmp] == 0) {
                    cnt++;
                }
                checkList[tmp]++;
                if (i == k - 1) {
                    //c 가 있었으면 cnt , 없었으면 cnt+1
                    if (checkList[c] == 0) {
                        max = Math.max(cnt + 1, max);
                    } else {
                        max = Math.max(cnt, max);
                    }
                    if (max == k + 1) break;
                }
            } else {
                int r = li.remove(0);
                checkList[r]--;
                //삭제 했는데 해당 숫자의 개수가 0이 되면 cnt -- 아니면 cnt 변경없이 사용
                if(checkList[r] == 0) cnt--;
                int tmp = input[i];
                li.add(tmp);
                // 새로운 숫자가 들어온거면 cnt++, 이미 있던 숫자였으면 cnt++ 하지 않고 숫자의 개수만 ++
                if (checkList[tmp] == 0) {
                    cnt++;
                }
                // 숫자 들어왔으니까 해당 숫자의 개수 ++
                checkList[tmp]++;

                if (checkList[c] == 0) {
                    max = Math.max(cnt + 1, max);
                } else {
                    max = Math.max(cnt, max);
                }

                
                if (max == k + 1) break;

            }


        }
        System.out.println(max);
    }
}