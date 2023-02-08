package day_0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17478_송종호 {
    static int N;
    static int count =1;
    static String tmp = "----";
    static String tmp2 ="----";
    static String str1 = "\"재귀함수가 뭔가요?\"\n";
    static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어\".";

    static String str5 = "라고 답변하였지.\n";

    static void output(){
        str1 = tmp + str1;
        str2 = tmp + str2;
        str3 = tmp + str3;
        str4 = tmp + str4;



        System.out.println(str1 + str2 + str3 + str4);

        tmp = tmp2+tmp;

        count++;
        if(count == N){
            System.out.println(tmp + "\"재귀함수가 뭔가요?\"");
            System.out.println(tmp + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            output2();
            return;
        }
        output();
    }
    static void output2(){
        count--;
        System.out.print(tmp + str5);
        tmp = tmp.substring(0,(tmp.length()-4));
        if(count == 0){
            return;
        }
        output2();
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        if(N ==1){
            System.out.println(str1+str2+str3+str4);
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(str5);
            return;
        }

        System.out.println(str1+str2+str3+str4);
        output();

        System.out.println(str5);



    }
}
