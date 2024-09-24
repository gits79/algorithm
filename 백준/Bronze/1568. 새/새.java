import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            int count = 0;
            int k = 1;

            while (n > 0) {
                if (n < k) {
                    k = 1;
                } else {
                    n = n - k;
                    k = k + 1;
                    count = count + 1;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
