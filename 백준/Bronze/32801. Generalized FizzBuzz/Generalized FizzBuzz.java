import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans_a = 0;
        int ans_b = 0;
        int ans_c = 0;
        for(int i = 1; i <= N; i++) {
            if(i % A == 0 && i % B == 0) {
                ans_a ++;
            } else if(i % A == 0) {
                ans_b ++;
            } else if(i % B == 0) {
                ans_c ++;
            }
        }

        System.out.printf("%d %d %d" , ans_b , ans_c , ans_a);
    }
}
