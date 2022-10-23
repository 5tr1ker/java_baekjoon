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
		
		st = new StringTokenizer(br.readLine() , " ");
		int maxlength = 0 , lowerlength = 0;
		int element[] = new int[N];
		for(int i = 0; i < N; i++) {
			element[i] = Integer.parseInt(st.nextToken());
			maxlength = Math.max(maxlength, element[i]);
			lowerlength = Math.min(lowerlength, element[i]);
		}
		
		int half = 0;
		long total;
		while(lowerlength < maxlength) {
			total = 0;
			half = (maxlength + lowerlength) / 2;
			
			for(int idx : element) {
				if(idx - half > 0) total += idx - half;
			}
			
			//System.out.println("최소 : " + lowerlength + " 최대 : " + maxlength + " 중간값 : " + half + " 결과값 : "+ total);
			
			if(total < dest) {
				maxlength = half;
			} else {
				lowerlength = half + 1;
			}
		}
		System.out.println(lowerlength - 1);
	}

}