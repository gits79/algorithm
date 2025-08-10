import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student {


        int index;
        int age;
        String name;

        public Student(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
    }


    static List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            students.add(new Student(i, age, name));

        }
        Collections.sort(students, (s1, s2) -> (s1.age == s2.age) ? s1.index - s2.index : s1.age - s2.age);

        for (Student student : students) {
            System.out.println(student.age + " " + student.name);
        }


    }
}
