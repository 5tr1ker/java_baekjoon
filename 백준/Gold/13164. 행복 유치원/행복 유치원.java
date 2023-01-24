import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int greedy[] = new int[N - 1];
		int idx = N - K;
		int i;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(i = 0; i < N - 1; i++)
			greedy[i] = arr[i + 1] - arr[i];
		
		Arrays.sort(greedy);
		int result = 0;
		
		for(i = 0; i < idx; i++)
			result += greedy[i];
		
		System.out.println(result);
	}
}