import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int arrB[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TS = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(TS-- > 0) {
			st = new StringTokenizer(br.readLine() , " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arrA[] = new int[N];
			arrB = new int[M];
			
			st = new StringTokenizer(br.readLine() , " ");
			for(int i = 0; i < N; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine() , " ");
			for(int i = 0; i < M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arrB);
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				count += solved(arrA[i]);
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int solved(int idx) {
		int min = 0;
		int max = arrB.length;
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(arrB[half] >= idx) {
				max = half;
			} else {
				min = half + 1;
			}
		}
		
		return min;
	}
	
}