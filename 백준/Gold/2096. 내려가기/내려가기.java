import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] minValue = new int[2][3];
		int[][] maxValue = new int[2][3];
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0 ; i < 3; i++) {
			minValue[0][i] = maxValue[0][i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		if(N == 1) {
			min = Math.min(min , Math.min(minValue[0][0], Math.min(minValue[0][1] , minValue[0][2])));
			max = Math.max(max , Math.max(maxValue[0][0], Math.max(maxValue[0][1] , maxValue[0][2])));
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			for(int j = 0; j < 3 ; j++) {
				minValue[1][j] = maxValue[1][j] = Integer.parseInt(st.nextToken());
			}
			
			maxValue[1][0] += Math.max(maxValue[0][0] , maxValue[0][1]);
			maxValue[1][1] += Math.max(Math.max(maxValue[0][0] , maxValue[0][1]) , maxValue[0][2]);
			maxValue[1][2] += Math.max(maxValue[0][2] , maxValue[0][1]);
			
			minValue[1][0] += Math.min(minValue[0][0] , minValue[0][1]);
			minValue[1][1] += Math.min(Math.min(minValue[0][0] , minValue[0][1]) , minValue[0][2]);
			minValue[1][2] += Math.min(minValue[0][2] , minValue[0][1]);
			
			for(int j = 0; j < 3 ; j++) {
				minValue[0][j] = minValue[1][j];
				maxValue[0][j] = maxValue[1][j];
			}
		}
		
		min = Math.min(min , Math.min(minValue[0][0], Math.min(minValue[0][1] , minValue[0][2])));
		max = Math.max(max , Math.max(maxValue[0][0], Math.max(maxValue[0][1] , maxValue[0][2])));
		
		System.out.println(max + " " + min);
	}
	
}