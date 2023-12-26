import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        BigInteger P = new BigInteger(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());


        BigInteger i = new BigInteger("2");
        for( ; ; i = i.add(BigInteger.ONE)) {
            if(i.compareTo(K) > 0) {
                System.out.println("GOOD");

                return;
            }

            if(P.mod(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) < 0) {
                System.out.println("BAD " + i);

                return;
            }
        }

    }
}
