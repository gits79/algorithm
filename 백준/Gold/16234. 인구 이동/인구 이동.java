
import java.util.*;
import java.io.*;

public class Main {

    
    static class Point {
        int x, y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    static int n, a, b;
    static int[][] arr;
    static boolean[][] v;
    static boolean chk;

    static void bfs(int i, int j, List<Point> union) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j});
                union.add(new Point(i, j, arr[i][j]));

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            int prev = arr[i][j];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
               
               if (0 <= ni && ni < n && 0 <= nj && nj < n && !v[ni][nj]) {
                    int next = arr[ni][nj];
                    int abs = Math.abs(prev - next);
                   
                    if (abs <= b && abs >= a) {
                     
                        chk = true;
                        v[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        
                        union.add(new Point(ni, nj, next));
                    }
                }
            }
        }
        
        if (!chk) {
            union.clear(); 
        }
    }

    static void update(List<Point> union) {
        int sum = 0;
        for (Point p : union) {
            sum += p.value;
        }
        int avg = sum / union.size();
        for (Point p : union) {
            arr[p.x][p.y] = avg;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        while (true) {
            v = new boolean[n][n];
            chk = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) {
                        List<Point> union = new ArrayList<>();
                        bfs(i, j, union);
                        
                        if (!union.isEmpty())
                            update(union);
                    }
                }
            }

            if (!chk) break;
            idx++;
        }
        System.out.println(idx);
    }
}
