import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static public int N , M , L;
	static public int sade[];
	static public int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine() , " ");
		sade = new int[N];
		arr = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			sade[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sade);
		
		int min , max;
		int count = 0;
		for(int i = 0; i < M; i++) {
			min = 0; max = N - 1;
			while(min < max) { // x에 가까운 사대 찾기
				int half = (min + max) / 2;
				
				if(sade[half] < arr[i][0]) {	// 좌표 x 보다 낮다면?
					min = half + 1;
				} else { 	// 사대의 좌표가 더 높다면?
					max = half;
				}
			}
			// System.out.printf("half : %d , min : %d , max : %d 새 : %d \n" , (min+max)/2 , min , max , i);
			if(Math.abs(sade[min] - arr[i][0]) + arr[i][1] <= L) {
				count++;
				// System.out.printf("새 x : %d , y : %d 를 잡은 사대 사대 %d \n" , arr[i][0] , arr[i][1] , sade[min]);
			}
		}
		System.out.println(count);
	}

}