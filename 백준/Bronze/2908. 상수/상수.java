import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();
        int ans1 = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
        sb = new StringBuilder();
        int ans2 = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());

        System.out.println(Math.max(ans1 , ans2));
    }
}