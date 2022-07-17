import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N , count = 0 , standard = 0;
		int score[][];
		for(int i = 0; i < T ; i++) {
			N = Integer.parseInt(br.readLine());
			count = 1;
			standard = 0 ;
			score = new int[N][3];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine() , " ");
				score[j][0] = Integer.parseInt(st.nextToken());
				score[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score , Comparator.comparingInt(o1 -> o1[0]));
			for(int j = 1; j < N; j++) {
				if(score[standard][1] > score[j][1] || score[standard][0] > score[j][0]) {
					standard = j;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}