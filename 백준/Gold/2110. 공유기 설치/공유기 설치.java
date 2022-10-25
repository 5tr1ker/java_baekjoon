import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int min = 1;
		int max = arr[N - 1] - arr[0] + 1;
		while(max > min) {
			
			int half = (max + min) / 2;
			
			if(check(half) < C) {
				max = half;
			} else {
				min = half + 1;
			}
		}
		System.out.println(min - 1);
	}
	
	public static int check(int half) {
		int count = 1;
		int locate = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - locate >= half) {
				count++;
				locate = arr[i];
			}
		}
		return count;
	}
}
