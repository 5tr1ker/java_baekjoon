import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public int arr[];
	static public int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int min = 0 , max = 10000*100000;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, arr[i]);
		}
		
		int result = 0;
		while(max >= min) {
			int half = (min + max) / 2;
			
			if(binarySearch(half) <= M) {
				result = half;
				max = half - 1;
			} else {
				min = half + 1;
			}
		}
		
		System.out.println(result);
	}
	
	public static int binarySearch(int half) {
		int count = 1;
		int money = half;
		for(int i = 0; i < N; i++) {
			money -= arr[i];
			if(money < 0) {
				count++;
				money = half - arr[i];
			}
		}
		return count;
	}

}