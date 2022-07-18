import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean D[] = new boolean[N + 1];

		D[0] = true;
		D[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N) ; i++) {
			for(int j = i * i; j <= N ; j += i) {
				D[j] = true;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!D[i]) {
				System.out.println(i);
			}
		}
	}
}