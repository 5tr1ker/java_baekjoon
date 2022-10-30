import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public int arr[];
	static public int N , M;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int min = 0 , max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.max(min, arr[i]);
			max += arr[i];
		}
		
		while(min < max) {
			int half = (min + max) / 2;
			if(check(half) <= M) {
				max = half;
			} else {
				min = half + 1;
			}
		}
		
		System.out.println(min);
	}
	
	public static int check(int half) {
		int count = 1;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] + sum > half) {
				sum = arr[i];
				count++;
			} else {
				sum += arr[i];
			}
		}
		
		return count;
	}

}