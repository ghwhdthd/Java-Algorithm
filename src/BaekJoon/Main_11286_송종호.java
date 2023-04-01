package ssafy.algo;

import java.io.*;
import java.util.PriorityQueue;

public class Main_11286_송종호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pQue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp !=0){
                pQue.offer(new Num(tmp));
            }else{
                if(pQue.isEmpty()){
                    sb.append(0).append("\n");
                }else {
                    sb.append(pQue.poll().num).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();



    }


}
class Num implements Comparable<Num>{
    int num;
    int absNum;

    Num(int num){
        this.num = num;
        this.absNum = Math.abs(num);
    }

    @Override
    public int compareTo(Num o) {
        //절댓값이 같을때는 음수값을 선택
        //절댓값이 작은 걸 위로 올림
        return this.absNum - o.absNum==0 ? this.num - o.num : this.absNum - o.absNum;
    }
}