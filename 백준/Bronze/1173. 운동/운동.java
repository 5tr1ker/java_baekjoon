import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = m;

        int ans = -1;

        int cnt = 0;
        int i = 0;
        int before = 0;
        for ( ; ; i++) {
            if(before == X) {
                break;
            }
            before = X;

            // System.out.println(i + "번째 맥박 : " + X);
            if(cnt == N) {
                ans = i;
                break;
            }

            // 운동하기
            if (X + T <= M) {
                X += T;
                cnt++;

                continue;
            } // 휴식하기

            if(X - R > m) {
                X -= R;
            } else {
                X = m;
            }
        }

        System.out.println(ans);
    }
}