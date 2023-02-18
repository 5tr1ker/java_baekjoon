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
		Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[7];
        
        visited[0] = true;
        q.add(select[0]);
        int cnt = 1, sCnt = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(arr[comY[cur]][comX[cur]] == 'S') sCnt++;
            
            for(int i=0; i<4; i++) {
                for(int next=1; next<7; next++) {
                    if(!visited[next] && comX[cur]+coorX[i] == comX[select[next]] && comY[cur]+coorY[i] == comY[select[next]]) {
                        visited[next] = true;
                        q.add(select[next]);
                        cnt++;
                    }
                }
            }
        }
        
        /* 7개 모두 연결되어 있다면 */
        if(cnt == 7) {
            if(sCnt >=4) {
                ans++;
            }
        }
	}
	
}