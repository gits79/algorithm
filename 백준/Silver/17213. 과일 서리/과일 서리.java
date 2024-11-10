import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static int[] arr;

    static int sum() {
        int summ = 0;
        for (int i = 0; i < N; i++) {
            summ += arr[i];
        }
        return summ;
    }

    static void recur(int cur) {
    	// 모든 종류의 과일을 적어도 1개는 훔치기때문에
    	// 모든 종류의 과일을 이미 1개씩 훔쳤다생각하면 
    	// M - N 개에 대한 순열을 세움
        if (sum() == M - N) { // 훔친개 M - N 개라면
            answer++;
            return;
        }
        // 개수를 초과하거나 종류의 범위를 넘는다면 리턴
        if (sum() > M - N || cur >= N) return;

        arr[cur]++;
        recur(cur); 
        arr[cur]--; 
        recur(cur + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];

        recur(0);
        System.out.println(answer);
    }
}
