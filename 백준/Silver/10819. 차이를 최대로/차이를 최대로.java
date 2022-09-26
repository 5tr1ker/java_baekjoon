import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public int arr[];
	static public int N;
	static public int index[];
	static public boolean check[];
	static public int maxValue = 0;
	
	public static void bruthForce(int count) {
		if(count == N) {
			int total = 0;
			for(int i = 0; i < N - 1; i++) {
				total += Math.abs(index[i] - index[i + 1]);
			}
			maxValue = Math.max(maxValue, total);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				index[count] = arr[i];
				bruthForce(count + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		check = new boolean[N];
		index = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			check[i] = true;
			index[0] = arr[i];
			bruthForce(1);
			check[i] = false;
		}
		
		System.out.println(maxValue);
	}
}