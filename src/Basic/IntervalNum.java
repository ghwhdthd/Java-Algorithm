public class IntervalNum {
    public long[] solution(long x, int n) { //x를 int 형으로 하면 안되는 이유는 형변환을 많이 해야하니까 라고 생각함.
        long[] answer = new long[n];

        for(int i=0; i<n; i++)
        {
            answer[i] = x*(i+1); // 여기서 x가 int 형이면 answer배열에 넣을때마다 형변환 계속 해야함

        }
        return answer;
}
