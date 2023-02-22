import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int arr[];
	static int max = 0;
	static int prefixSum[];
	static int reversPrefixSum[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		arr = new int[N];
		prefixSum = new int[N];
		reversPrefixSum = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		prefixSum[0] = arr[0];
		reversPrefixSum[N - 1] = arr[N - 1];
		for(int i = 1; i < N; i++) {
			prefixSum[i] = arr[i] + prefixSum[i - 1];
		}
		for(int i = N - 2; i >= 0; i--) {
			reversPrefixSum[i] = arr[i] + reversPrefixSum[i + 1];
		}
		
		solved1(); // 벌 1 , 빈통 고정
		solved2(); // 벌 1 , 빈통 고정
		solved3(); // 벌 1 , 벌 2 고정
		
		System.out.println(max);
	}
	
	public static void solved1() {
		for(int i = 1; i < N - 1; i++) {
			int sum1 = prefixSum[N - 1] - prefixSum[0] - arr[i]; // 벌통 1 값
			int sum2 = prefixSum[N - 1] - prefixSum[i]; // 벌통 2 값
			
			max = Math.max(max, sum1 + sum2);
		}
	}
	
	public static void solved2() {
		for(int i = 1 ; i < N - 1; i++) {
			int sum1 = reversPrefixSum[0] - reversPrefixSum[N - 1] - arr[i]; // 벌통 1값
			int sum2 = reversPrefixSum[0] - reversPrefixSum[i]; // 벌통 2 값
			
			max = Math.max(max, sum1 + sum2);
		}
	}
	
	public static void solved3() {
		for(int i = 1; i < N - 1; i++) {
			int sum1 = prefixSum[i] - prefixSum[0];
			int sum2 = reversPrefixSum[i] - reversPrefixSum[N - 1];
			
			max = Math.max(sum1 + sum2, max);
		}
		
	}
	
}