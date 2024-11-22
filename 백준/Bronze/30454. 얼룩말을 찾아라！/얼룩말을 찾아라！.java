import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0; i < N; i++) {
            String input[] = br.readLine().split("");

            String prev = "0";
            int cnt = 0;

            for(int j = 0; j < L; j++) {
                if(input[j].equals("1")) {

                    if(prev.equals("0")) {
                        cnt++;
                        prev = "1";
                    }
                } else {
                    prev = "0";
                }
            }

            if(ans1 < cnt) {
                ans1 = cnt;
                ans2 = 1;
            } else if (cnt == ans1) {
                ans2++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
