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
        StringBuilder sb = new StringBuilder();

        solved(sb, N, " @@@   @@@ ");
        solved(sb, N, "@   @ @   @");
        solved(sb, N, "@    @    @");
        solved(sb, N, "@         @");
        solved(sb, N, " @       @ ");
        solved(sb, N, "  @     @  ");
        solved(sb, N, "   @   @   ");
        solved(sb, N, "    @ @    ");
        solved(sb, N, "     @     ");

        System.out.println(sb);
    }

    public static void solved(StringBuilder sb, int N, String str) {
        for(int i = 0; i < N; i++) {
            sb.append(str);

            if(N - 1 > i) {
                sb.append(" ");
            }
        }
        sb.append("\n");
    }
}
