package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_송종호 {
    static int N;
    static int r;
    static int c;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N);
        pro(r,c,size);
        System.out.println(num);
        br.close();
    }
    static void pro(int r, int c, int size){
        int curSize = size;
        int halfSize = size/2;
        if(curSize == 2){
            if(r<halfSize && c<halfSize){
                num+=0;
            }if(r<halfSize && c>=halfSize){
                num += 1;
            }if(r>=halfSize && c<halfSize){
                num += 2;
            }if(r>=halfSize && c>=halfSize){
                num += 3;
            }
            return;
        }

        if(r<halfSize && c<halfSize){
            pro(r,c,halfSize);
        }if(r<halfSize && c>=halfSize){
            num += halfSize*halfSize;
            if(c-halfSize >=0) c=c-halfSize;
            pro(r,c,halfSize);
        }if(r>=halfSize && c<halfSize){
            num += halfSize*halfSize*2;
            if(r-halfSize >=0) r=r-halfSize;
            pro(r,c,halfSize);
        }if(r>=halfSize && c>=halfSize){
            num += halfSize*halfSize*3;
            if(r-halfSize >=0) r=r-halfSize;
            if(c-halfSize >=0) c=c-halfSize;
            pro(r,c,halfSize);
        }
    }
}
