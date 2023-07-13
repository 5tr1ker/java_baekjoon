import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[5];
int ans = 1;

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            int cnt = 0;
            for(int i = 0; i < 5; i++) {
                if(ans % arr[i] == 0) {
                    cnt++;
                }
            }

            if(cnt >= 3) {
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }
}