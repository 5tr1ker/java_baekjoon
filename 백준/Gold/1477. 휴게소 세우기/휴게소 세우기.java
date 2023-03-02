import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N , M , L;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 2];
		arr[0] = 0;
		arr[1] = L;
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 2; i < N + 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = 1 , max = L;
		
		while(min < max) {
			int half = (min + max) / 2;
			if(solved(half) > M) {
				min = half + 1;
			} else {
				max = half;
			}
		}
		
		System.out.println(min);
	}
	
	public static int solved(int idx) {
		int count = 0;
		
		for(int i = 0; i < N + 1; i++) {
			count += (arr[i + 1] - arr[i] - 1) / idx;
		}
		
		return count;
	}
	
}