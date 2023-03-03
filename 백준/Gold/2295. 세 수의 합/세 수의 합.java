import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int sum[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		sum = new int[N * N];
		for(int i = 0; i < N; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				sum[count++] = arr[i] + arr[j];
			}
		}
		
		Arrays.sort(sum);
		
		for(int i = N - 1; i >= 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(solved(arr[i] - arr[j])) {
					System.out.println(arr[i]);
					return;
				}
			}
		}
	}
	
	public static boolean solved(int idx) {
		int min = 0;
		int max = sum.length;
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(sum[half] == idx) {
				return true;
			}
			
			if(sum[half] > idx) { // 현재 값이 더 크다?
				max = half;
			} else {	// 현재 값이 더 작다.
				min = half + 1;
			}
		}
		
		return false;
	}
	
	
}