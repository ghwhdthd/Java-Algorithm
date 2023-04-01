package ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17478_송종호 {
    static int N;
    static String tmp = "____";
    static String tmp2 = "____";
    static String str1 = "\"재귀함수가 뭔가요?\"\n";
    static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static String str5 = "라고 답변하였지.\n";
    static String str6 = "라고 답변하였지.";

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0,"");
        System.out.println(sb.toString());

    }
    static void recur(int depth,String underLine){
        if(depth == N) {
            String str = underLine;

            sb.append(str).append(str1);
            sb.append(str).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(str).append(str5);
            return;
        }
        sb.append(underLine).append(str1);
        sb.append(underLine).append(str2);
        sb.append(underLine).append(str3);
        sb.append(underLine).append(str4);
        recur(depth+1,underLine + "____");
        sb.append(underLine).append(str5);

    }

}