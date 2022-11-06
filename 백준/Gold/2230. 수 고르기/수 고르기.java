import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			int min = i;
			int max = N;
			
			while(max > min) {
				int half = (min + max) / 2;
				int sum = arr[half] - arr[i];
				
				if(sum < M) {
					min = half + 1;
				} else {
					max = half;
				}
				
				if(max == N) continue;
				
				result = Math.min(result, arr[max] - arr[i]);
				
				if(result == M) break;
			}
		}
		System.out.println(result);
	}
}