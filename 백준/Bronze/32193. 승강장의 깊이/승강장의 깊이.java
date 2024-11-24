import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int prevA = 0;
        int prevB = 0;

        for(int i = 0; i < N; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            prevA += A;
            prevB += B;

            System.out.println(prevA - prevB);
        }
    }
}
