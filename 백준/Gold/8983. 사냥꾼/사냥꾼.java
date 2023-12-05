import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static public int N , M , L;
	static public int sade[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine() , " ");
		sade = new int[N];
		
		for(int i = 0; i < N; i++) {
			sade[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sade);
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int result = binarySearch(x , y , 0 , N - 1);
			
			if(Math.abs(sade[result] - x) + y <= L) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static public int binarySearch(int x , int y , int N , int M) {
		int min = N;
		int max = M;
		
		while(min < max) { // x에 가까운 사대 찾기
			int half = (min + max) / 2;
			
			if (Math.abs(sade[half] - x) + y <= L || sade[half] == x)
				return half;
			
			if(sade[half] < x) {	// 좌표 x 보다 낮다면?
				min = half + 1;
			} else { 	// 사대의 좌표가 더 높다면?
				max = half;
			}
		}
		
		if(min > M) {
			return max;
		}
		
		if(M < N) {
			return min;
		}
		return (Math.abs(sade[min] - x) < Math.abs(sade[max] - x) ? min : max);
	}

}