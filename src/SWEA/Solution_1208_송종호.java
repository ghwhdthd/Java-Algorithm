package day_0207;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1208_송종호 {
    int T = 10;
    static BufferedReader br;
    static int dumpCount;
    static List<Integer> li = new ArrayList<>();
    static void input()throws IOException{
       dumpCount = Integer.parseInt(br.readLine());
       String str = br.readLine();
       StringTokenizer st =new StringTokenizer(str, " ");
       while(st.hasMoreTokens()){
           li.add(Integer.parseInt(st.nextToken()));
       }
    }
    static void pro(){

        //정렬 후 max - 1, min + 1 을 수행 -> 이걸 반복
        for(int i=0; i<dumpCount; i++){
            Collections.sort(li);
            int max = li.get(li.size()-1);
            int min = li.get(0);
            if(max -min <= 1) break;
            li.set(li.size()-1,max-1);
            li.set(0,min+1);
        }


    }
    public static void main(String[] args)throws IOException  {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i= 1; i<=1; i++){
            input();
            pro();
            Collections.sort(li);
            int max = li.get(li.size()-1);
            int min = li.get(0);
            System.out.println("#" + i + " "+(max-min));
            li.clear();
        }
    }
}
