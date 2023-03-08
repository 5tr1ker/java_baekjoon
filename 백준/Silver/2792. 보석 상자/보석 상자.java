import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N , M , arr[] , max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(binarySearch());
		
	}
	
	public static int binarySearch() {
		int min = 0;
		
		while(min < max) {
			int half = (min + max) / 2;
			int count = 0;
			
			for(int i = 0; i < M; i++) {
				count += Math.ceil((double)arr[i] / half);
				//System.out.println("sum : " + Math.ceil((double)arr[i] / half));
			}
			
			//System.out.printf("min : %d , max : %d , half : %d , count : %d \n" , min , max , half , count);
			if(count > N) {
				min = half + 1;
			} else {
				max = half;
			}
		}
		
		//System.out.println("return : " + min);
		return min;
		
	}
	
}