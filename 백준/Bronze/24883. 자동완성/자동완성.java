import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ch = br.readLine();
        String result = "Naver Whale";
        if (ch.equals("N") || ch.equals("n")) {
            result = "Naver D2";
        }
        System.out.print(result);
    }
}
