import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[4][8];
    static int[] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            rotate = new int[4];
            rotate[gearNum] = dir;

            // 왼쪽 확인
            for (int i = gearNum; i > 0; i--) {
                if (arr[i][6] != arr[i - 1][2]) {
                    rotate[i - 1] = -rotate[i];
                } else break;
            }

            // 오른쪽 확인
            for (int i = gearNum; i < 3; i++) {
                if (arr[i][2] != arr[i + 1][6]) {
                    rotate[i + 1] = -rotate[i];
                } else break;
            }

            // 회전 실행
            for (int i = 0; i < 4; i++) {
                if (rotate[i] == 1) turnRight(arr[i]);
                else if (rotate[i] == -1) turnLeft(arr[i]);
            }
        }

        // 점수 계산
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += (1 << i);
            }
        }

        System.out.println(answer);
    }

    static void turnRight(int[] gear) {
        int temp = gear[7];
        for (int i = 7; i > 0; i--) {
            gear[i] = gear[i - 1];
        }
        gear[0] = temp;
    }

    static void turnLeft(int[] gear) {
        int temp = gear[0];
        for (int i = 0; i < 7; i++) {
            gear[i] = gear[i + 1];
        }
        gear[7] = temp;
    }
}
