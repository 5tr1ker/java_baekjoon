import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ball = br.readLine();
		int ans = Integer.MAX_VALUE;
		
		int rCnt = 0;
		int bCnt = 0;
		for(int i = 0; i < N; i++) {
			if(ball.charAt(i) == 'R') {
				rCnt++;
			} else {
				bCnt++;
			}
		}
		// 오른쪽으로 밀기
		// 파란공
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(ball.charAt(i) == 'B') {
				cnt++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, bCnt - cnt);
		
		// 빨간공
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(ball.charAt(i) == 'R') {
				cnt++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, rCnt - cnt);
		
		// 왼쪽으로 밀기
		// 파란공
		cnt = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(ball.charAt(i) == 'B') {
				cnt++;
			}else {
				break;
			}
		}
		ans = Math.min(ans, bCnt - cnt);
		
		// 빨간공
		cnt = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(ball.charAt(i) == 'R') {
				cnt++;
			}else {
				break;
			}
		}
		ans = Math.min(ans, rCnt - cnt);
		
		System.out.println(ans);
	}
}