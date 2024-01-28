import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int c = gcd(A , B);

            System.out.println(A * B / c);
        }


    }

    public static int gcd(int a , int b) {

        while(b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}