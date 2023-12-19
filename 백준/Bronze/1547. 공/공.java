import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ball = 1;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(X == ball) {
                ball = Y;
            }
            else if (Y == ball) {
                ball = X;
            }
        }

        System.out.println(ball);
    }
}
