import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static public int index[];
	static public boolean check[];
	static public int N;
	static public StringBuffer sb;
	
	public static void bruthForce(int number) {
		
		if(number == N) {
			for(int i = 0; i < N; i++) {
				sb.append(index[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				index[number] = i + 1;
				check[i] = true;
				bruthForce(number + 1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		
		index = new int[N];
		check = new boolean[N];
		
		
		bruthForce(0);
		System.out.println(sb);
	}

}