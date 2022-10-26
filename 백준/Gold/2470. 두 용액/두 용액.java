import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int min = 0;
		int max = N - 1;
		int mid = Integer.MAX_VALUE;
		int index1 = 0 , index2 = 0;
		
		while(min < max) {
			int sum = arr[min] + arr[max];
			int abs_sum = Math.abs(sum);
			
			if(abs_sum <= mid) {
				mid = abs_sum;
				index1 = arr[min];
				index2 = arr[max];
			}
			
			if(sum < 0) {
				min++;
			} else {
				max--;
			}
		}

		System.out.printf("%d %d \n", index1, index2);
	}

}