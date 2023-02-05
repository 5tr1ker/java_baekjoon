import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x , y , cnt;
	
	public Point(int x , int y , int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	
	public static int coorX[] = {-1,1,0,0};
	public static int coorY[] = {0,0,-1,1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        StringTokenizer st;
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine() , " ");
        	for(int j = 0; j < N; j++) {
        		int idx = Integer.parseInt(st.nextToken());
        		arr[i][j] = idx;
        	}
        }
        
        // 섬의 구역 찾기
        int idx = 2;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(arr[i][j] == 1) {
        			Queue<int []> queue = new LinkedList<int[]>();
        			queue.offer(new int[] {i , j});
        			arr[i][j] = idx;
        			
        			while(!queue.isEmpty()) {
        				int data[] = queue.poll();
        				
        				for(int z = 0; z < 4; z++) {
        					int dx = data[0] + coorX[z];
        					int dy = data[1] + coorY[z];
        					
        					if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
        					
        					if(arr[dx][dy] == 1) {
        						queue.offer(new int[] {dx , dy});
        						arr[dx][dy] = idx;
        					}
        				}
        			}
        			idx++;
        		}
        	}
        }
        
        // 최단거리 찾기
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(arr[i][j] != 0) {
        			for(int z = 0; z < 4; z++) {
        				int dx = i + coorX[z];
        				int dy = j + coorY[z];
        				
        				if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
        				
        				if(arr[dx][dy] == 0) {
        					Queue<Point> queue = new LinkedList<Point>();
        					boolean check[][] = new boolean[N][N];
        					queue.offer(new Point(dx , dy , 1));
        					check[dx][dy] = true;
        					
        					while(!queue.isEmpty()) {
        						Point pnt = queue.poll();
        						
        						for(int v = 0; v < 4; v++) {
        							int px = pnt.x + coorX[v];
        							int py = pnt.y + coorY[v];
        							
        							if(px < 0 || py < 0 || px >= N || py >= N || check[px][py] || pnt.cnt + 1 > ans) continue;
        							
        							if(arr[px][py] == 0) {
        								check[px][py] = true;
        								queue.offer(new Point(px , py , pnt.cnt + 1));
        							}
        							else if(arr[px][py] != arr[i][j]) {
        								ans = Math.min(ans, pnt.cnt);
        								queue.clear();
        							}
        						}
        					}
        				}
        			}
        			
        		}
        	}
        }
        
        System.out.println(ans);
    }


}