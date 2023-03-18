import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		boolean flag = true;
		while (true) {
			flag = true;
			
			for(int i = 0; i < N; i++) {
				if(arr[i] % 2 == 1) { // 홀수는 계산
					arr[i]--;
					ans++;
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(arr[i] != 0) 
					flag = false;
			}
			if(flag) break;
			
			for (int i = 0; i < N; i++) { // 모든 수를 2로 나누기
				arr[i] /= 2;
			}
			ans++;
		}
		
		System.out.println(ans);
	}
}