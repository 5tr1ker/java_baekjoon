import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result[] = new long[21];
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int start = Integer.parseInt(st.nextToken());
		
		result[start] = 1;
		long tmp[];
		for(int z = 0; z < N - 2; z++) {
			int idx = Integer.parseInt(st.nextToken());
			tmp = new long[21];
			for(int i = 0; i <= 20; i++) {
				if(result[i] != 0) {
					if(i - idx >= 0) tmp[i - idx] += result[i];
					if(i + idx <= 20) tmp[i + idx] += result[i];
				}
			}
			
			result = tmp.clone();
		}
		
		int end = Integer.parseInt(st.nextToken());
		System.out.println(result[end]);
	}
	
}