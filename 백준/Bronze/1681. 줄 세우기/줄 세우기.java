import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();

        int answer = 1;
        int count = 0;
        while(count != N){
            if((answer + "").contains(L)) {
                answer++;
                continue;
            }
            answer++;
            count++;
        }


        System.out.print(answer - 1);
    }
}
