import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TS = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(TS-- > 0) {
            st = new StringTokenizer(br.readLine() , " ");
            int R = Integer.parseInt(st.nextToken());
            String str[] = st.nextToken().split("");

            StringBuilder sb = new StringBuilder();
            for(String data : str) {
                for(int i = 0; i < R; i++) {
                    sb.append(data);
                }
            }
            System.out.println(sb);
        }
    }
}