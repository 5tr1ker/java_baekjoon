import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;

        int min = 100;
        for(int i = 0; i < 4; i++) {
            int input = Integer.parseInt(br.readLine());

            ans += input;
            min = Math.min(min, input);
        }
        ans -= min;

        min = 100;
        for(int i = 0; i < 2; i++) {
            int input = Integer.parseInt(br.readLine());

            ans += input;
            min = Math.min(min, input);
        }
        ans -= min;

        System.out.println(ans);
    }

}