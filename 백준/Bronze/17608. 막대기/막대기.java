import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());

        int input[] = new int[h];
        for(int i = 0; i < h; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int ans = 0;
        for(int i = h - 1; i >= 0; i--) {
            if(max < input[i]) {
                ans++;
                max = input[i];
            }
        }

        System.out.println(ans);
    }
}