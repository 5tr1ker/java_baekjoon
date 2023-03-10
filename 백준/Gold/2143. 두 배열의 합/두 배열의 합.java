import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static ArrayList<Long> sumA , sumB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		long []arrA = new long[N + 1];
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arrA[i] = arrA[i - 1] + num;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		long []arrB = new long[M + 1];
		for(int i = 1; i <= M; i++) {
			int num = Integer.parseInt(st.nextToken());
			arrB[i] = arrB[i - 1] + num;
		}
		
		sumA = new ArrayList<Long>();
		for(int i = N ; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				sumA.add(arrA[i] - arrA[j]);
			}
		}
		Collections.sort(sumA);
		
		sumB = new ArrayList<Long>();
		for(int i = M ; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				sumB.add(arrB[i] - arrB[j]);
			}
		}
		Collections.sort(sumB);
		
		System.out.println(binarySearch());
	}
	
	public static long binarySearch() {
		long ans = 0;
		
		for(int i = 0; i < sumA.size(); i++) {
			long idx = sumA.get(i);
			long result = upperBound(idx) - lowerBound(idx);
			if(result > 0) {
				ans += result;
			}
		}
		
		return ans;
	}
	
	public static int lowerBound(long idx) {
		int min = 0;
		int max = sumB.size();
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(sumB.get(half) + idx < T) {
				min = half + 1;
			} else {
				max = half;
			}
			
		}
		
		return max;
	}
	
	public static int upperBound(long idx) {
		int min = 0;
		int max = sumB.size();
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(sumB.get(half) + idx <= T) {
				min = half + 1;
			} else {
				max = half;
			}
		}
		
		return min;
	}
	
}