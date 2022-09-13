import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int map[];
	static int count = 0;
	static int N;
	
	public static void queen(int index) {
		if(index == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[index] = i;
			
			if(check(index)) {
				queen(index + 1);
			}
		}
	}
	
	public static boolean check(int index) {
		
		for(int i = 0; i < index; i++) {
			if(map[index] == map[i]) return false;
			
			if(Math.abs(index - i) == Math.abs(map[i] - map[index])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		queen(0);
		
		System.out.println(count);
	}
}