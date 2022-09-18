import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int dest , N;
	public static boolean button[];
	public static int result;
	
	public static void bruthForce(int nowChannel , int count) {
		
		result = Math.min(result, Math.abs(nowChannel - dest) + count);
		if(count == 10 || nowChannel > dest) {
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(!button[i]) bruthForce(nowChannel * 10 + i , count + 1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dest = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		button = new boolean[10];
		
		StringTokenizer st = null;
		if(N != 0) st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			button[Integer.parseInt(st.nextToken())] = true;
		}
		
		if(dest == 100) {
			System.out.println(0);
			return;
		}
		
		result = Math.abs(100 - dest);
		for(int i = 0; i < 10; i++) {
			if(!button[i]) {
				bruthForce(i , 1);
			}
		}
		System.out.println(result);
	}
}