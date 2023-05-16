import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int ans = 0;

        for(String str2 : str) {
            if (!str2.isEmpty()) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}