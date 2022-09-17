import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N , S;
	public static int arr[];
	public static int total = 0;
	
	public static void bruthForce(int index , int sum) {
		
		if(index == N) {
			if(sum == S) {
				total++;
			}
			return;
		}

		bruthForce(index + 1, sum + arr[index]);
		bruthForce(index + 1, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		bruthForce(0 , 0);
		if(S == 0) System.out.println(total - 1);
		else System.out.println(total);
	}

}