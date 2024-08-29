import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    static int n, a, b;
    static int[][] arr;
    static boolean[][] v;
    
    // 연합을 찾기 위한 BFS 함수
    static List<Point> bfs(int i, int j) {
        List<Point> union = new ArrayList<>();
        int sum = arr[i][j];
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        v[i][j] = true;
        union.add(new Point(i, j));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = p.x + di[d];
                int nj = p.y + dj[d];
                
                if (0 <= ni && ni < n && 0 <= nj && nj < n && !v[ni][nj]) {
                    int diff = Math.abs(arr[p.x][p.y] - arr[ni][nj]);
                    if (a <= diff && diff <= b) {
                        v[ni][nj] = true;
                        q.offer(new Point(ni, nj));
                        union.add(new Point(ni, nj));
                        sum += arr[ni][nj];
                    }
                }
            }
        }
        return union;
    }
    
    // 연합의 인구를 업데이트하는 함수
    static void update(int[][] arr, List<Point> union) {
        int size = union.size();
        if (size == 0) return;
        int avg = 0;
        for (Point p : union) {
            avg += arr[p.x][p.y];
        }
        avg /= size;
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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int days = 0;
        while (true) {
            v = new boolean[n][n];
            boolean moved = false;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) {
                        List<Point> union = bfs(i, j);
                        if (union.size() > 1) {
                            update(arr, union);
                            moved = true;
                        }
                    }
                }
            }
            
            if (!moved) break;
            days++;
        }
        
        System.out.println(days);
    }
}
