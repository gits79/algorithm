import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayList<int[]> lst = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst.add(new int[]{a, b});
        }

        Collections.sort(lst, (o1, o2) -> o1[0] - o2[0]);

        int cnt = 0;
        int coverLen = 0; // 웅덩이 커버한 마지막 길이

        for (int[] arr : lst) {
            int start = arr[0]; // 웅덩이 시작점
            int end = arr[1]; // 웅덩이 끝점
            // 웅덩이 시작점을 널빤지로 커버하지 못하면
            if (start > coverLen) {
                cnt++;
                coverLen = start + L; // 널빤지는 웅덩이 시작점 + L 만큼 커버
            }
            // 널빤지 커버 끝지점이 웅덩이 끝지점에 도달 못하면 다시 L만큼 커버
            while (coverLen < end) {
                coverLen += L;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
