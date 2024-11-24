import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= i; j++) {
                ans += i + j;
            }
        }

        System.out.println(ans);
        // 4 = 1 2 3 4 5 6 7 8
        // 3 = 1 2 3 4 5 6 7 8 9
        // 2 = 1 2 3 4
        // 1 = 1 2
    }
}
