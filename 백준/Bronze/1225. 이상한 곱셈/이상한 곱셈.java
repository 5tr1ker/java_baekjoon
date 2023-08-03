import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        String A[] = st.nextToken().split("");
        String B[] = st.nextToken().split("");

        long ans = 0;
        for(int i = 0; i < A.length; i++) {
            int Adata = Integer.parseInt(A[i]);
            for(int j = 0; j < B.length; j++) {
                int Bdata = Integer.parseInt(B[j]);

                ans += Adata * Bdata;
            }
        }

        System.out.println(ans);

    }
}