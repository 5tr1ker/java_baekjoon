import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[6];
		int min_num[] = new int[3];
		st = new StringTokenizer(br.readLine() , " ");
		
		for(int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if ( N == 1 ) {
			Arrays.sort(arr);
			System.out.println(arr[0] + arr[1] + arr[2] + arr[3] + arr[4]);
			return;
		}
		
		min_num[2] = Math.min(arr[2] , arr[3]); // 윗면 아랫면중에 작은 수
		arr[2] = arr[5];
		arr[3] = arr[4];
		arr[4] = arr[0];
		int standard = 9999;
		for(int i = 0; i < 4; i++) {
			if(arr[i] + arr[i + 1] < standard) {
				standard = arr[i] + arr[i + 1];
				min_num[0] = arr[i];
				min_num[1] = arr[i + 1];
			}
		}
		
		Arrays.sort(min_num);
		
		Long count = 0L;
		
		count += (min_num[0] + min_num[1] + min_num[2]) * 4; // 3의자리
		count += (min_num[0] + min_num[1]) * ((N - 2) * 4 + (N - 1) * 4) ; // 2의자리
		count += (min_num[0]) * (long)(Math.pow(N - 2 , 2) + (long)(N - 1) * (N - 2) * 4L) ;// 1의자리

		System.out.println(count);
	}
}
