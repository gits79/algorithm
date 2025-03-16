import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean chk = false;

        for (int i = 1; i <= 5; i++) {
            String str = br.readLine();
            if (str.contains("FBI")) {
                System.out.print(i + " ");
                chk = true;
            }
        }

        if (!chk)
            System.out.println("HE GOT AWAY!");
    }
}
