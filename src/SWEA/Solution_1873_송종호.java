package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1873_송종호 {
    static int H;
    static int W;
    static int N;
    static String USER;
    static LinkedList<Character> li;
    static LinkedList<LinkedList<Character>> li2 =new LinkedList<>();
    static LinkedList<Integer>[] li3 = new LinkedList[10];


    static int locationR;
    static int locationC;
    public static void main(String[] args) throws IOException {
        for(int i=0; i<10; i++){
            li3[i].add(3);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                li = new LinkedList<>();
                for (int j = 0; j < W; j++) {
                    li.add(str.charAt(j));
                }
                li2.add(li);
            }
            for(int i = 0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(li2.get(i).get(j) == '<' ||li2.get(i).get(j) == '^' ||li2.get(i).get(j) == 'v' ||li2.get(i).get(j) == '>'){
                        locationR = i;
                        locationC = j;
                    }
                }
            }
            N = Integer.parseInt(br.readLine());
            USER = br.readLine();
            for (int i = 0; i < USER.length(); i++) {
                char in = USER.charAt(i);
                pro(in);
            }
        }
    }

    static void pro(char in){
        if(in == 'U'){
            up();
        }else if(in == 'D'){
            down();
        }else if(in == 'L'){
            left();
        }else if(in == 'R'){
            right();
        }else if(in == 'S'){
            shoot();
        }
    }
    static void up(){
        upcheck();
    }
    static void down(){
        downcheck();
    }
    static void left(){
        leftcheck();
    }
    static void right(){
        rightcheck();
    }
    static void shoot(){

    }
    static boolean upcheck(){
        li2.get(locationR).set(locationC,'^');
        if(locationR > 0) return true;
        else return false;

    }static boolean downcheck(){
        li2.get(locationR).set(locationC,'v');
        if(locationR > 0) return true;
        else return false;
    }static boolean leftcheck(){
        li2.get(locationR).set(locationC,'<');
        if(locationR > 0) return true;
        else return false;
    }static boolean rightcheck(){
        li2.get(locationR).set(locationC,'>');
        if(locationR > 0) return true;
        else return false;
    }
}

//        1
//        3 7
//        ***....
//        *-..#**
//        #<.****
//        23
//        SURSSSSUSLSRSSSURRDSRDS
//
//        **....v
//        .-..#..
//        #......