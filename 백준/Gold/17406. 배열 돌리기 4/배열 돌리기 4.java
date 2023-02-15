import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int r , c , s;

	public Point(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class Main {
	
	// bruthForce 에 사용될 값
	public static int direct[];
	public static boolean check[];
	
	public static int N , M , K;
	public static int arr[][];
	public static int copy_arr[][];
	public static Point turn[];
	public static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		copy_arr = new int[N + 1][M + 1];
		turn = new Point[K];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			turn[i] = new Point(r, c, s);
		}
		
		direct = new int[K];
		check = new boolean[K];
		bruthForce(0);
		
		System.out.println(ans);
	}
	
	static public void solved() {
		for(int z = 0; z < K; z++) {
			Point pnt = turn[direct[z]];
			for(int t = 1; t <= pnt.s; t++) {
				// 한틱당 조회해야 할 요소
				int resource = t * 2;
				int x = Math.abs(t - pnt.r);
				int y = Math.abs(t - pnt.c);
				// 임시 배열 저장소
				int tmp1 = copy_arr[x + 1][y]; // 넣을 값
				int tmp2 = 0;
				// 오른쪽 이동
				for(int i = 0; i < resource; i++ , y++) {
					tmp2 = copy_arr[x][y];
					copy_arr[x][y] = tmp1;
					tmp1 = tmp2;
				}
				
				// 아래로
				for(int i = 0; i < resource; i++ , x++) {
					tmp2 = copy_arr[x][y];
					copy_arr[x][y] = tmp1;
					tmp1 = tmp2;
				}
				
				// 왼쪽으로
				for(int i = 0; i < resource; i++ , y--) {
					tmp2 = copy_arr[x][y];
					copy_arr[x][y] = tmp1;
					tmp1 = tmp2;
				}
				
				// 위로
				for(int i = 0; i < resource; i++ , x--) {
					tmp2 = copy_arr[x][y];
					copy_arr[x][y] = tmp1;
					tmp1 = tmp2;
				}
			}
		}
		
		calculate();
	}
	
	static public void calculate() {
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = 0;
			for(int j = 1; j <= M; j++) {
				result += copy_arr[i][j];
			}
			ans = Math.min(ans, result);
		}
	}
	
	static public void bruthForce(int idx) {
		if(idx >= K) {
			for(int i = 1; i <= N; i++) {
				copy_arr[i] = arr[i].clone();
			}
			solved();
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!check[i]) {
				check[i] = true;
				direct[idx] = i;
				bruthForce(idx + 1);
				check[i] = false;
			}
		}
		
	}
}