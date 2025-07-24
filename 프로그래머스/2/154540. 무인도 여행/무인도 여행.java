import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    static int[] di = {-1 , 0, 1, 0};
    static int[] dj = {0 , 1, 0, -1};
    static boolean[][] visited;
    static int N, M, cnt;

    static void dfs(int i, int j, String[] maps) {
        visited[i][j] = true;
        cnt+= maps[i].charAt(j) - '0';
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(chkIdx(ni, nj) && !visited[ni][nj] && maps[ni].charAt(nj) != 'X'){
                dfs(ni, nj, maps);
            }
        }
    }

    static boolean chkIdx(int i, int j){
        if(0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }

    public static List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt = 0;
                if(!visited[i][j] && maps[i].charAt(j) != 'X') dfs(i, j, maps);
                if(cnt != 0) answer.add(cnt);
            }
        }


        Collections.sort(answer);
        if(answer.isEmpty()) answer.add(-1);
        return answer;
    }

}