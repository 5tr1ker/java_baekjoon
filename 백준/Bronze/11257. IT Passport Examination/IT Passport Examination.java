import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int score1 = Integer.parseInt(st.nextToken());
            int score2 = Integer.parseInt(st.nextToken());
            int score3 = Integer.parseInt(st.nextToken());

            boolean pass = false;
            if(score1 > 10 && score2 > 7 && score3 > 11 && score1 + score2 + score3 >= 55) {
                pass = true;
            }

            sb.append(name).append(" ").append(score1 + score2 + score3);
            if(pass) {
                sb.append(" PASS\n");

                continue;
            }
            sb.append(" FAIL\n");
        }
        System.out.println(sb);

    }

}