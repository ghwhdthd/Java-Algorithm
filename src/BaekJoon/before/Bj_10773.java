import java.util.*;
//제로
// stack을 사용해서 풀이
// 변수 input에 차례대로 push 그리고 input == 0 일때, pop
// peek & pop 으로 stack 에 남아있는 수 총합 구하기
public class Boj_10773 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        int count = in.nextInt();//

        int input = -1;

        int total = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<count; i++)
        {
            input = in.nextInt();

            if(input == 0)
            {
                stack.pop();
            }
            else
            {
                stack.push(input);
            }
        }
        while (stack.empty()==false)
        {
            total += stack.peek();
            stack.pop(); // peek만 하면 stack에서 값이 빠지지 않으므로 pop도 꼭 해줘야함.
        }
        System.out.println(total);
    }
}
