import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int M , N;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine() , " ");
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.println(binarySearch());
		
	}
	
	// 과자 기준으로 탐색
	public static int binarySearch() {
		int min = 1;
		int max = arr[N - 1];
		
		while(min <= max) {
			int half = (min + max) / 2;
			int count = 0;
			
			for(int i = 0; i < N; i++) {
			 	count += arr[i] / half;
			}
			
			if(count >= M) {
				min = half + 1;
			} else {
				max = half - 1;
			}
		}
		
		return max;
	}
	
}