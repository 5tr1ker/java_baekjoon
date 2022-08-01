import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int i;
		
		st = new StringTokenizer(br.readLine());
		for(i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 1;
		int standard = arr[0] + L;
		for(i = 1; i < N; i++) {
			if(standard <= arr[i]) {
				count++;
				standard = arr[i] + L;
			}
		}
		
		System.out.println(count);
	}

}
