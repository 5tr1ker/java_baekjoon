import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arrow[] = new int[1_000_002];
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if(arrow[input + 1] == 0) { // 화살 추가
				arrow[input]++;
				ans++;
			} else {
				arrow[input + 1]--;
				arrow[input]++;
			}
		}
		System.out.println(ans);
	}
}