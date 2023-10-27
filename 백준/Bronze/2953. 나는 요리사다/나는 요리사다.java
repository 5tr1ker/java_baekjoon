import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans = 0;
        int count = 0;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int j = 0; j < 4; j++)
                sum += Integer.parseInt(st.nextToken());

            if(count < sum) {
                ans = i + 1;
                count = sum;
            }
        }

        System.out.println(ans + " " + count);

    }
}