import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> hash1 = new HashSet<Integer>();
		HashSet<Integer> hash2 = new HashSet<Integer>();
		
		st = new StringTokenizer(br.readLine() , " ");
		int idx1 = 0;
		for(int i = 0; i < N; i++) {
			hash1.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine() , " ");
		int idx2 = 0;
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(!hash1.contains(input)) {
				idx2++;
			}
			hash2.add(input);
		}
		
		for(int input : hash1) {
			if(!hash2.contains(input)) {
				idx1++;
			}
		}
		
		System.out.println(idx1 + idx2);
	}

}
