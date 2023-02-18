import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int select[];
	static char arr[][];
	static int ans = 0;
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	static int comX[];
	static int comY[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		select = new int[7];
		comX = new int[25];
		comY = new int[25];
		
		for(int i = 0; i < 25; i++) {
			comX[i] = i / 5;
			comY[i] = i % 5;
		}
		
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < 5; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		combination(0,0,7);
		
		System.out.println(ans);
		
	}
	
	public static void combination(int idx , int cnt , int left) { // idx 선택 인덱스 , cnt 인덱스 번호 , left 남은 갯수
		if(left == 0) {
			bfs();
			return;
		}
		
		if(cnt >= 25) return;
		
		select[idx] = cnt;
		combination(idx + 1 , cnt + 1 , left - 1); // 선택합니다.
		combination(idx , cnt + 1, left); // 선택하지 않습니다.
	}
	
	public static void bfs() { // 연결 && 가능한 조합인가?
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean check[] = new boolean[7];
		check[0] = true;
		queue.offer(select[0]);
		
		int countQueue = 1;
		int countS = 0;
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			if(arr[comX[data]][comY[data]] == 'S') {
				countS++;
			}
			
			for(int i = 0; i < 4; i++) {
				int dx = comX[data] + coorX[i];
				int dy = comY[data] + coorY[i];
				for(int j = 1; j < 7; j++) {
					if(!check[j] && comX[select[j]] == dx && comY[select[j]] == dy) {
						check[j] = true;
						queue.offer(select[j]);
						countQueue++;
					}
				}
			}
		}
		
		if(countQueue >= 7 && countS >= 4) {
			ans++;
		}
	}
	
}