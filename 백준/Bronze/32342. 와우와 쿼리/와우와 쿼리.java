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
        int Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++) {
            String input[] = br.readLine().split("");
            int ans = 0;
            String prev = input[0];
            int cnt = 0;
            if(prev.equals("W")) {
                cnt = 1;
            }


            for(int j = 1; j < input.length; j++) {
                if(input[j].equals("W")) {
                    if(prev.equals("O") && cnt == 2) { // WO
                        ans += 1;
                        cnt = 1;
                    } else if(prev.equals("W")) {
                        cnt = 1;
                    } else if(prev.equals("O")) {
                        cnt = 1;
                    }
                    prev = "W";
                } else if (input[j].equals("O")) {
                    if(prev.equals("W")) {
                        cnt += 1;
                    } else if(prev.equals("O")) {
                        cnt = 0;
                    }
                    prev = "O";
                }
            }

            System.out.println(ans);
        }
    }
}
