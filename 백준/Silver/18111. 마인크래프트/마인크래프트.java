import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public int map[][];
	static public int N , M , block , maxValue = 0 , minValue = 256;
	static public int result[];

	public static void bruthForce(int destHeight , int blockCount) {
		int appendTime = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > destHeight) { // 산을 깎아야한다.
					int temp = map[i][j] - destHeight;
					appendTime += (Math.abs(temp) * 2);
					blockCount += Math.abs(temp);
				}
				
				else if(map[i][j] < destHeight) { // 블록 설치
					int temp = destHeight - map[i][j];
					
					appendTime += Math.abs(temp);
					blockCount -= Math.abs(temp);
				}
			}
		}
		
		if(result[0] >= appendTime && blockCount >= 0) {
			result[0] = appendTime;
			result[1] = destHeight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		block = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[2];
		
		result[0] = result[1] = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minValue = Math.min(minValue, map[i][j]);
				maxValue = Math.max(maxValue, map[i][j]);
			}
		}
		
		for(int i = minValue; i <= maxValue; i++) {
			bruthForce(i , block);
		}
		System.out.println(result[0] + " " + result[1]);
	}
}