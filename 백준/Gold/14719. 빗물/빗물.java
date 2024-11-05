import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static int[] arr;
    static int lmax, rmax;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ans = 0;
        // i번째 인덱스에 물이 고일 수 있는지
        for (int i = 1; i < W - 1; i++) {
        	lmax = 0;
            rmax = 0;
            
            // i기준 왼쪽 벽 중 가장 큰 애 찾기
            for (int j = 0; j < i; j++) {
                lmax = Math.max(arr[j], lmax);
//                System.out.print("lmax: " + lmax + " ");

            }
            // i기준 오른쪽 벽 중 가장 큰 애 찾기
            for (int k = i + 1; k < W; k++) {
                rmax = Math.max(arr[k], rmax);
//                System.out.print("rmax: " + rmax + " ");
            }
            
            int water = Math.min(lmax, rmax) - arr[i];

            if (water > 0) {
                ans += water;
            }

        }

        System.out.println(ans);
        
        br.close();
    }
}