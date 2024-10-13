import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans =  0;
        for(int i = 0; i < N ; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a % 2 != 0) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
