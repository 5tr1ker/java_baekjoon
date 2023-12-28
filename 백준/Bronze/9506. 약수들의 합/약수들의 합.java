import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int input = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder(input + " = ");

            if(input == -1) {
                return;
            }

            int sum = 0;
            for(int i = 1; i < input; i++) {
                if(input % i == 0) {
                    sb.append(i).append(" + ");

                    sum += i;
                }
            }

            if(sum == input) {
                sb.delete(sb.length() - 2, sb.length());
                System.out.println(sb);
            } else {
                System.out.printf("%d is NOT perfect.\n" , input);
            }
        }
    }
}
