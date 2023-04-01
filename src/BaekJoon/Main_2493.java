package ssafy.algo;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//탑
public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int max = -1;


        while (st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());
            if(max < now ) max = now;

            if(stack.isEmpty()) {
                stack.push(now);//6
                index.push(i);//0
                sb.append(index.peek()).append(" ");
            }
            else {
                if (now >= stack.peek()) {// 같아도 앞에꺼는 필요없음.
                    while(true){
                        if(now == max) break;
                        if(stack.peek() > now ){
                            break;
                        }
                        stack.pop();
                        index.pop();
                    }

                    if(now == max){
                        sb.append(0).append(" ");
                    }else{
                        sb.append(index.peek()+1).append(" ");
                    }
                    stack.push(now);//9
                    index.push(i);//1

                }
                else {
                    sb.append(index.peek()+1).append(" ");
                    stack.push(now);
                    index.push(i);

                }
            }
            i++;
        }

        System.out.println(sb.toString());

    }
}
