import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String strArr[] = br.readLine().split("");

            int idx = 0;
            int ans = 0;
            for(int j = 0; j < strArr.length; j++) {
                String str = strArr[j];
                if(str.equals("X")) {
                    idx = 0;
                } else {
                    idx ++;
                    ans += idx;
                }
            }

            System.out.println(ans);
        }
    }
}