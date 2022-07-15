import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int A[] = new int[N] , B[] = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		
		int total = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0 , j = N - 1 ; i < N; i++ , j--) {
			total += A[i] * B[j];
		}
		
		System.out.println(total);
	}

}
