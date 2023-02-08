public class EvenOdd {
    public String solution(int num) {
        String answer = "";
        if(num==0)
        {
            answer = "Even";

        }
        else if (num%2 != 0)
        {
            answer = "Odd";

        }
        else {
            answer = "Even";

        }
        return answer;
    }
}
