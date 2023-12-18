import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                cnt += 1;
            }

            if(cnt == K) {
                System.out.println(i);

                return;
            }
        }

        System.out.println(0);
    }
}
