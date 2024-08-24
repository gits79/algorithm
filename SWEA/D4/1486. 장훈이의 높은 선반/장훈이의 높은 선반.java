
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static int answer;

    static void recur(int cur){
        if(cur == n) {
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            if (sum >= m)
                answer = Math.min(answer, Math.abs(m - sum));
            return;
        }

        visited[cur] = true;
        recur(cur + 1);
        visited[cur] = false;
        recur(cur + 1);
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];
            answer = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            recur(0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(answer);
            System.out.println(sb);
        }

    }
}
