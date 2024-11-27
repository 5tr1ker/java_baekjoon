import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double ans = Math.pow(0.5, N);

        BigDecimal bd = new BigDecimal(ans).setScale(N, RoundingMode.HALF_UP);

        System.out.println(bd.toPlainString());
    }
}
