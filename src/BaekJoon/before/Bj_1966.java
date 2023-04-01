import java.util.*;

public class Boj_1966 {
    public static void main(String[] args) {

        Queue<Integer> queueIndex = new LinkedList<>();
        Queue<Integer> queue= new LinkedList<>(); // 중요도


        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int N; // 문서의 개수
        int M; // 해당 숫자의 위치

        int[] arr;
        int max =0;
        int answer;


        for(int i = 0; i<count; i++)
        {
            N = in.nextInt();//6 0
            M = in.nextInt();
            arr = new int[N];

            for(int j = 0; j<N; j++) {
                queueIndex.add(j); // 중요도 큐의 인덱스
                int temp = in.nextInt();//1 1 9 1 1 1
                queue.add(temp); // 중요도 큐
                arr[j] = temp; //중요도 배열// 9 1 1 1 1 1

            }

            Integer[] conv = Arrays.stream(arr).boxed().toArray(Integer[]::new);// int[] -> Integer[]
            Arrays.sort(conv,Collections.reverseOrder());// 중요도 배열 내림차순
            arr = Arrays.stream(conv).mapToInt(Integer::intValue).toArray(); // Integer[] -> int[]

            //내림차순은 우선순위 큐로도 구현이 가능함.

            for(int j =0; j<N; j++)
            {
                int end = 0;
                while (true)
                {

                    int temp;
                    int tempIndex;

                    //중요도 배열 내림차순 한 결과와 중요도 queue의 값이 같을때 j+1 출력
                    if(arr[j] == queue.peek())
                    {
                        queue.poll();
                        int a = queueIndex.poll();

                        if(a == M)
                        {
                            System.out.println(j+1);
                            end = 1;
                            break;
                        }
                        break;
                    }

                    //그렇지 않은 경우 queue에서 하나 poll 하고 add 하여 순서를 뒤로 보내줌
                    temp = queue.poll();
                    queue.add(temp);

                    tempIndex = queueIndex.poll();
                    queueIndex.add(tempIndex);

                }


                if(end == 1){break;}
            }

            //queue 꼭 초기화 해줘야함!
            queue.clear();
            queueIndex.clear();




        }
    }
}
