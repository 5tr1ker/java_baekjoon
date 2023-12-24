import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(":");

        int ans = 0;
        for(int i = 0; i < 3; i++) {
            int hour = Integer.parseInt(input[i]);

            if(hour <= 0 || hour > 12) {
                continue;
            }

            for(int j = 0; j < 3; j++) {
                int minute = Integer.parseInt(input[j]);

                if(minute < 0 || minute > 59 || i == j) {
                    continue;
                }

                for(int z = 0; z < 3; z++) {
                    int second = Integer.parseInt(input[z]);

                    if(second < 0 || second > 59 || z == i || z == j) {
                        continue;
                    }

                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
