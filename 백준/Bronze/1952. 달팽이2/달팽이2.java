import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static boolean visit[][];
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int M,N;
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         
         visit = new boolean[M][N];
         
         int x = 0;
         int y = 0;
         int dir = 1;
         int cnt = 0;
         
         while(true) {
             if(visit[y][x])
                 break;
             visit[y][x] = true;
             
             int newX = x + moveX[dir];
             int newY = y + moveY[dir];
             
             if(0>newX || newX>=N || 0>newY || newY >= M || visit[newY][newX]) {
                 if(dir==3)
                     dir = 0;
                 else
                     dir++;
                 cnt++;
             }
             x = x + moveX[dir];
             y = y + moveY[dir];
        }
         
        System.out.println(cnt-1);
         
    }
}
 
