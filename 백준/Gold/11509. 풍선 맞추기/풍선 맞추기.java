import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int arrow[] = new int[N];
		for(int i = 0; i < N; i++) {
			int balloon = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < N; j++) {
				if(arrow[j] == balloon + 1) {
					arrow[j] = balloon;
					break;
				} else if(arrow[j] == 0) {
					arrow[j] = balloon;
					break;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			if(arrow[i] != 0) ans++;
		}
		System.out.println(ans);
	}
	
	
}