package ssafy.algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main_3040_송종호 {
    static int total;
    static int tmp;
    static boolean end;
    static List<Integer> dwarf = new LinkedList<>(); // 난쟁이
    static List<Integer> except = new ArrayList<>();// 제외될 난쟁이
    static int[] candi = new int[2];// 제외될 난쟁이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            int temp = Integer.parseInt(br.readLine());
            dwarf.add(temp);
            total += temp;
        }
        //조합 구현 9C2
        comb(0,0);
        dwarf.remove(except.get(0));
        dwarf.remove(except.get(1));

        for(int i=0; i<dwarf.size(); i++){
            System.out.println(dwarf.get(i));
        }

    }
    static void comb(int depth, int start){

        if(depth == 2) {
            int tmp = candi[0]+candi[1];
            if(total - tmp == 100){
                except.add(candi[0]);
                except.add(candi[1]);

            }
            return;
        }
        for(int i = start; i<9; i++){
            candi[depth] = dwarf.get(i);
            comb(depth+1,i+1);




        }
    }
}
