import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split("");
        for(int i = 1; i < N; i++) {
            String nextInput[] = br.readLine().split("");

            for(int j = 0; j < nextInput.length; j++) {
                if(!input[j].equals(nextInput[j])) {
                    input[j] = "?";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }

        System.out.println(sb);
    }
}