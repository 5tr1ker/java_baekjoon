import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        Integer result[][] = new Integer[N][M];
        
        for(int i = 0; i < N; i++) {
        	String str[] = br.readLine().split("");
        	for(int j = 0; j < M; j++) {
        		arr[i][j] = Integer.parseInt(str[j]);
        	}
        }
        
        Queue<int []> queue = new LinkedList<int[]>();
        result[0][0] = 0;
        queue.offer(new int[] {0 , 0});
        
        while(!queue.isEmpty()) {
        	int []data = queue.poll();
        	int y = data[0];
        	int x = data[1];
        	
        	for(int z = 0; z < 4; z++) {
        		int idx = 0;
        		int dx = x + coorX[z];
        		int dy = y + coorY[z];
        		if(dx < 0 || dy < 0 || dx >= M || dy >= N) 
        			continue;
        		
        		if(arr[dy][dx] == 1)
        			idx = 1;
        		
        		if(result[dy][dx] == null || result[dy][dx] > result[y][x] + idx) {
        			result[dy][dx] = result[y][x] + idx;
        			queue.offer(new int[] {dy , dx});
        		}
        	}
        }
        
        System.out.println(result[N - 1][M - 1]);
        
	}
}