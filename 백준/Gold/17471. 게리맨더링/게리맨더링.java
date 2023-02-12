import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static boolean check[];
	static boolean visited[];
	static int map[][];
	static int people[];
	static int N;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		people = new int[N + 1];
		check = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for(int j = 0; j < tmp; j++) {
				int line = Integer.parseInt(st.nextToken());
				map[line][i] = map[i][line] = 1;
			}
		}
		
		for(int i = 1; i < N; i++) {
			bruteForce(i , 0 , 1);
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);			
		}
		
	}
	
	public static int bfs(int idx , boolean group) {
		int total = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		visited[idx] = true;
		total += people[idx];
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(map[data][i] == 1 && !visited[i] && check[i] == group) {
					queue.offer(i);
					visited[i] = true;
					total += people[i];
				}
			}
		}
		
		return total;
	}
	
	public static int solved() {
		int groupA = 0;
		int groupB = 0;
		visited = new boolean[N + 1];
		// 각 그룹 계산
		for(int i = 1; i <= N; i++) {
			if(check[i]) {
				groupA = bfs(i , true);
				break;
			}
		}
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				groupB = bfs(i , false);
				break;
			}
		}
		
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) { // 방문 안한곳이 있다면
				return -1;
			}
		}
		
		return Math.abs(groupA - groupB);
		
	}
	
	public static void bruteForce(int idx , int cnt , int resource) {
		if(cnt >= idx) {
			int result = solved();
			if(result >= 0) {
				ans = Math.min(ans, result);
			}
			return;
		}
		
		for(int i = resource; i <= N; i++) {
			if(!check[i]) {
				check[i] = true;
				bruteForce(idx , cnt + 1 , i);
				check[i] = false;
			}
		}
	}
}