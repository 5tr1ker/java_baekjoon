import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TK = Integer.parseInt(br.readLine());

        while(TK-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int temp = (int) Math.pow(N , 2);

            if(N >= 1000) {
                if((temp % 10000) == N) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if ( N >= 100) {
                if((temp % 1000) == N) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if ( N >= 10 ) {
                if((temp % 100) == N) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                if((temp % 10) == N) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
