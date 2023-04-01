package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10814 {
    static ArrayList<Person> li = new ArrayList<>();
    static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }


        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            li.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(li);
        for(int i =0; i<N; i++){
            System.out.println(li.get(i).age + " " + li.get(i).name);
        }
    }
}
