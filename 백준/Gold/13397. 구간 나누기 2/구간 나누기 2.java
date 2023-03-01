import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N , M;
	static int arr[];
	static int INF = 999_999_999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine() , " ");
		arr = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, arr[i]);
		}
		
		min = 0;
		
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
		int section = 1;
		int min = INF;
		int max = -INF;
		
		for(int i = 0; i < N; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			
			if(max - min > idx) {
				section++;
				min = INF;
				max = -INF;
				i--;
			}
		}
		
		return section;
	}
	
}