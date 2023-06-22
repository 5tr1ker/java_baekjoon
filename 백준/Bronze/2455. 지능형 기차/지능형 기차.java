import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int cnt = 0;
    int max=0;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            cnt -= out;
            cnt += in;

            if(cnt > 10000) {
                cnt = 10000;
            }

            max = Math.max(max , cnt);
        }

        System.out.println(max);
    }
}