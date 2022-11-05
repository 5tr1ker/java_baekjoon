import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int arr[];
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			int max = N - 1;
			int min = 0;
			
			while(max > min) {
				long sum = arr[min] + arr[max];
				
				if(sum == arr[i]) {
					if(i == min) {
						min++;
					} else if (i == max) {
						max--;
					} else {
						count++;
						break;
					}
				} else {
					if(sum > arr[i]) {
						max--;
					} else {
						min++;
					}
				}
				
			}
			
		}
		
		System.out.println(count);
	}

}