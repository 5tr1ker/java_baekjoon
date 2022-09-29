import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 2) {
			System.out.println(1);
			return;
		}
		
		Long arr[] = new Long[N];
		arr[0] = arr[1] = 1L;
		for(int i = 2; i < N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		System.out.println(arr[N - 1]);
	}

}