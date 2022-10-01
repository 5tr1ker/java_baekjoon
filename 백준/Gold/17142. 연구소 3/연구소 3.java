import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Virus> viruses = new ArrayList<>();
    static Virus[] active;
    static int resultMinTime = Integer.MAX_VALUE;
    static int originEmptySpace = 0;
	
	static class Virus {
        int x, y, time;

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		active = new Virus[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0 ) originEmptySpace++;
				if(arr[i][j] == 2 ) viruses.add(new Virus(j , i , 0));
			}
		}
		
		if(originEmptySpace == 0) {
			System.out.println(0);
			return;
		}
		
		findVirus(0 , 0);
		
		System.out.println(resultMinTime == Integer.MAX_VALUE ? -1 : resultMinTime);
	}
	
	public static void findVirus(int idx , int count) {
		if(count == M) {
			spreadVirus(originEmptySpace);
			return;
		}
		
		for(int i = idx ; i < viruses.size(); i++) {
			active[count] = viruses.get(i);
			findVirus(i + 1 , count + 1);
		}
	}
	
	public static void spreadVirus(int time) {
		Queue<Virus> queue = new LinkedList<Virus>();
		boolean check[][] = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			Virus a = active[i];
			queue.add(a);
			check[a.y][a.x] = true;
		}
		
		while(!queue.isEmpty()) {
			Virus data = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = data.x + dx[i];
				int ny = data.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(arr[ny][nx] == 1 || check[ny][nx]) continue;
				
				if(arr[ny][nx] == 0) {
					time--;
				}
				
				if(time == 0) {
					resultMinTime = Math.min(data.time + 1, resultMinTime);
					return;
				}
				
				check[ny][nx] = true;
				queue.add(new Virus(nx , ny , data.time + 1));
			}
		}
	}
	
}