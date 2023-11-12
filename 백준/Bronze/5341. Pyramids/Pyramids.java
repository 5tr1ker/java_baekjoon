import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(true) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0)
                return;

            int ans = 0;
            for(int i = 1; i <= input; i++) {
                ans += i;
            }

            System.out.println(ans);
            
        }
    }
}