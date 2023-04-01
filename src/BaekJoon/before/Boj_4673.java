//구현 문제임.
public class Boj_4673 {
    static int N;
    static char[] Narr;
    static String s;



    static int d(int n){
        int res = n;
        N = n;
        s = String.valueOf(N);
        Narr = s.toCharArray();
        for(int i = 0; i<Narr.length; i++){
            res = res + (Narr[i]-'0');
        }
        return res;
    }
    public static void main(String[] args) {
        boolean [] check = new boolean[10001];

        for(int i =1; i<=10000; i++){
            check[i] = false;
        }

        for(int i = 1; i<=10000; i++){
            int res = d(i);
            if(res > 10000) continue;

            check[res] = true;
        }

        for(int i =1; i<check.length; i++){
            if(!check[i]){
                System.out.println(i);
            }
        }



    }
}
