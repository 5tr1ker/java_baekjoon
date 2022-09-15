import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static int total = 0;
	static int N;
	static int max = Integer.MIN_VALUE;
	
	public static void bruthForce(int today , int money) {
		
		if(today >= N) {
			max = Math.max(max, money);
			return;
		}
		
		if(arr[today][0] + today <= N) {
			bruthForce(arr[today][0] + today , money + arr[today][1]);
		} else {
			bruthForce(today + 1, money);
		}
		
		bruthForce(today + 1 , money);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bruthForce(0 , 0);
		System.out.println(max);
	}

}