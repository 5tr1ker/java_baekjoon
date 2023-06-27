import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double max = 0;
        double newScore = 0.0;
        int score[] = new int[N];

        for(int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max , score[i]);
        }

        for(int i = 0; i < N; i++) {
            newScore += score[i] / max * 100.0;
        }

        System.out.println(newScore / N);
    }
}