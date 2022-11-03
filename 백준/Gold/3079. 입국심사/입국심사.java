import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public int arr[];
	static public int N , M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int maxValue = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		long min = 0L;
		long max = (maxValue) * 1000000000L;
		
		
		while(min <= max) {
			long half = (max + min) / 2;
			long result = binarySearch(half);
			if(result >= M) {
				max = half - 1;
			} else {
				min = half + 1;
			}
		}
		
		System.out.println(min);
	}
	
	public static long binarySearch(long half) {
		long count = 0;
		for(int i = 0; i < N; i++) {
			count += half / arr[i]; 
		}
		return count;
	}
}