import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[];
	static boolean visited[];
	static boolean finished[];
	static int count = 0;
	
	static void dfs(int now) { 
        if(visited[now])
            return;
 
        visited[now] = true;
        int next = arr[now];
 
        if(visited[next] != true)
            dfs(next);
        else {
            if(finished[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }
 
        // 모든 작업이 끝나서 더이상 사용하지 않음
        finished[now] = true;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int z = 0; z < T; z++) {
			int N = Integer.parseInt(br.readLine());
			count = 0;
			
			arr = new int[N + 1];
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];
			
			st = new StringTokenizer(br.readLine() , " ");
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= N; i++) {
				dfs(i);
			}
			
			System.out.println(N - count);
		}
	}
}