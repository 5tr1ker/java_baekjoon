import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char ch[] = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        char a = br.readLine().charAt(0);
        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(ch[i] == a) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
