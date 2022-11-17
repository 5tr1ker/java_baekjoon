import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long arr[] = new long[N];
			long cnt = 0;
			long max = 0;
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = N - 1; j >= 0; j--) {
				if(max < arr[j]) {
					max = arr[j];
				} else {
					cnt += max - arr[j];					
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}