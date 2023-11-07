import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) {
                break;
            }

            if (Math.pow(C, 2) == Math.pow(A, 2) + Math.pow(B, 2)) {
                sb.append("right\n");
                continue;
            }

            if (Math.pow(B, 2) == Math.pow(A, 2) + Math.pow(C, 2)) {
                sb.append("right\n");
                continue;
            }

            if (Math.pow(A, 2) == Math.pow(B, 2) + Math.pow(C, 2)) {
                sb.append("right\n");
                continue;
            }

            sb.append("wrong\n");
        }

        System.out.println(sb);
    }
}