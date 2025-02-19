import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int count = 0; 
        arr[0] = 1; 
        int ball = 0; 
        boolean isGameOver = false; 
        boolean flag = false; 
        while (!isGameOver) {
            
            for (int i = 0; i < N; i++) {
                if (arr[i] == M) { 
                    isGameOver = true;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            if (arr[ball] % 2 == 0) {
                ball = (ball + L) % N; 
            } else {
                ball = (ball + (N - L)) % N; 
            }
            arr[ball]++;
            count++;
        }

        System.out.println(count);
    }
}