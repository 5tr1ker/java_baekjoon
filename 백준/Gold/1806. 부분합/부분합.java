import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N + 1];
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int length = Integer.MAX_VALUE;
		int start = 0 , end = 0;
		int sum = 0;
		while(end <= N) {
			if(sum >= S) { // 조건에 만족하면
				length = Math.min(length, end - start);
				sum -= arr[start++];
			}
			else if (sum < S) { // 합이 모자를 때
				sum += arr[end++];
			}
		}
		
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}