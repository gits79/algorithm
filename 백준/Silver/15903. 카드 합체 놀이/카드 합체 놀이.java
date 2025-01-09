import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        Long answer = 0L;

        for(int i = 0 ; i < M ; i++){
            Long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
            Arrays.sort(arr);
        }

        for(int i = 0 ; i < N ; i++){
            answer += arr[i];
        }

        System.out.println(answer);

    }

}
