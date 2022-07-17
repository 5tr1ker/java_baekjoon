import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N , count = 0 , standard = 0 , x , y;
		int score[];
		for(int i = 0; i < T ; i++) {
			N = Integer.parseInt(br.readLine());
			count = 1;
			standard = 1;
			score = new int[N + 1];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine() , " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				score[x] = y;
			}
			for(int j = 2; j <= N; j++) {
				if(score[j] < score[standard]) {
					standard = j;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}