import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BigInteger a1 = new BigInteger(st.nextToken());
        BigInteger a2 = new BigInteger(st.nextToken());

        System.out.println(a1.divide(a2) + "\n" + a1.mod(a2));
    }
}