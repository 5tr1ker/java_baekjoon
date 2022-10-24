import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		int element[] = new int[N];
		long max = 0, min = 0;
		for(int i = 0; i < N; i++) {
			element[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, element[i]);
		}
		
		max++;
		while(max > min) {
			long index = 0;
			long half = (max + min) / 2;
			
			for(int data : element) {
				index += data / half;
			}
			
			if(index < dest) {
				max = half;
			} else {
				min = half + 1;
			}
		}
		System.out.println(min - 1);
	}
}