import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char arr[][];
	static int ans = 0;
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	
	// 조합론
	static int comX[];
	static int comY[];
	static int select[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		comX = new int[25];
		comY = new int[25];
		select = new int[7];
		
		for(int i = 0 ; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < 5; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < 25; i++) {
			comX[i] = i / 5;
			comY[i] = i % 5;
		}
		
		combinate(0, 0, 7);
		
		System.out.println(ans);
		
	}
	
	public static void combinate(int idx , int cnt , int left) {
		if(left <= 0) {
			bfs();
			return;
		}
		
		if(cnt >= 25) return;
		
		select[idx] = cnt;
		combinate(idx + 1 , cnt + 1 , left - 1); // 선택하기
		combinate(idx , cnt + 1 , left); // 버리기
	}
	
	// 시작
	public static void bfs() {
		Queue<int []> queue = new LinkedList<int []>();
		boolean check[][] = new boolean[5][5];
		boolean visited[][] = new boolean[5][5];
		int count = 0; // BFS 횟수
		int countS = 0; // S 횟수
		for(int i = 0; i < 7; i++) {
			int dx = select[i] / 5;
			int dy = select[i] % 5;
			
			check[dx][dy] = true;
			if(queue.isEmpty())
				queue.offer(new int[] {dx , dy});
		}
		
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = data[0] + coorX[i];
				int dy = data[1] + coorY[i];
				
				if(dx < 0 || dy < 0 || dx >= 5 || dy >= 5) continue;
				
				if(check[dx][dy] && !visited[dx][dy]) {
					count++;
					if(arr[dx][dy] == 'S') countS++;
					queue.offer(new int[] {dx , dy});
					visited[dx][dy] = true;
				}
			}
		}
		
		if(count >= 7 && countS >= 4) {
			ans++;
		}
		
	}
	
}