import java.io.*;
import java.util.*;

public class Main {

    static int N, X = 101, Y = 101;
    static int[][] map = new int[X][Y];


    static int sum() {
        int summ = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                summ += map[i][j];
            }
        }
        return summ;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        System.out.println(sum());


    }
}
