import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int ans = 0;
        int seq = 1;
        for(int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            if(next == 1) {
                ans += seq;

                seq++;
                continue;
            }

            seq = 1;
        }

        System.out.println(ans);
    }
}
