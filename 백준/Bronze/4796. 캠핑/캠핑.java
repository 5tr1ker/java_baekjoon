import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int L , P , V;
		for(int i = 1; ; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			if(L == 0 && P == 0 && V == 0) break;
			if((V % P) < L) System.out.printf("Case %d: %d\n" , i , (V / P * L) + (V % P));
			else System.out.printf("Case %d: %d\n" , i , (V / P * L) + L);
		}
	}

}