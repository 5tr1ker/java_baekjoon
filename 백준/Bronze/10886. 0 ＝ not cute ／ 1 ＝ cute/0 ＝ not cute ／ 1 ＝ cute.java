import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 1) {
                cnt ++;
            }
        }

        if(cnt > N / 2) {
            System.out.println("Junhee is cute!");

            return;
        }

        System.out.println("Junhee is not cute!");


    }
}