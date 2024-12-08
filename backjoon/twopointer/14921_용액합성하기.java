package boj;

import java.io.*;
import java.util.*;

public class Main_용액합성하기_14921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int answer = Integer.MAX_VALUE;


        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }

            if (sum < 0) left++;
            else right--;


        }

        System.out.println(answer);

    }
}
