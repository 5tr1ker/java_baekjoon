import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st2.nextToken());
        double ans = 0.0;
        for(int i = 0; i < 6; i++) {
            ans += Math.ceil(Double.parseDouble(st.nextToken()) / a);
        }
        System.out.println((int) ans);

        int b = Integer.parseInt(st2.nextToken());
        System.out.println(N / b + " " + N % b);

    }
}
