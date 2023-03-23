import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static public int parent[];
	
	public static void union(int idx1 , int idx2) {
		int p1 = findParent(idx1);
		int p2 = findParent(idx2);
		
		if(p1 > p2)	parent[p1] = p2;
		else parent[p2] = p1;
	}
	
	public static int findParent(int idx) {
		if(parent[idx] == idx) {
			return idx;
		}
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int price[] = new int[N + 1];
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start , end);
		}
		
		int pay[] = new int[N + 1];
		Arrays.fill(pay, 11111); // 값이 변동되지 않은 경우 -> 친구의 친구
		for(int i = 1; i <= N; i++) {
			int friend = findParent(i);
			
			pay[friend] = Math.min(pay[friend], price[i]); // 친구비가 더 싼 친구
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if(pay[i] != 11111) {
				ans += pay[i];
			}
		}
		
		if(ans <= K) {
			System.out.println(ans);
		} else {
			System.out.println("Oh no");
		}
	}

}