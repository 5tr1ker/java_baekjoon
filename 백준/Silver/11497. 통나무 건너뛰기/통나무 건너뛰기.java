import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int z = 0; z < T; z++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int arr[] = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int arr2[] = new int[N];
			int idx1 = 0;
			int idx2 = N - 1;
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					arr2[idx1++] = arr[i];
				} else {
					arr2[idx2--] = arr[i];
				}
			}
			
			int max = Math.abs(arr2[N - 1] - arr2[0]);
			
			for(int i = 0 ; i < N - 1; i++) {
				max = Math.max(max, Math.abs(arr2[i + 1] - arr2[i]));
			}
			
			System.out.println(max);
		}
	}

}