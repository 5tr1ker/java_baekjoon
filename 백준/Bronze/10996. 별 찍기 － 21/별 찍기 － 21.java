import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(N == 1) {
            System.out.println("*");

            return;
        }

        for(int i = 0; i < N * 2 ; i++) {
            for(int j = 0; j < N; j++) {
                if((j + i) % 2 == 0) {
                    sb.append("*");

                    continue;
                }

                sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}