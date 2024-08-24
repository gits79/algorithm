import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i = 0; i < n; i++)
                arr[i] = br.readLine();


            int sum = 0;
            int mid = n / 2;
            for(int i = 0; i <= mid; i++){
                for(int j = mid - i; j <= mid + i; j++){
                    sum += Character.getNumericValue(arr[i].charAt(j));
                }
            }
            for(int i = mid + 1; i < n; i++){
                for(int j = mid - (n - i - 1); j <= mid + (n - i - 1); j++){
                    sum += Character.getNumericValue(arr[i].charAt(j));
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(sum);
            System.out.println(sb);


        }


    }
}
