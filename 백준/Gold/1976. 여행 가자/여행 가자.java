import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int parent[];
	
	static public int findParent(int idx) {
		if(parent[idx] == idx) return idx;
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	static public void union(int idx1 , int idx2) {
		int i1 = findParent(idx1);
		int i2 = findParent(idx2);
		
		if(i1 != i2) parent[i1] = i2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				int idx = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				if(idx == 1) union(i , j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = 0;
		boolean flag = true;
		
		while(st.hasMoreTokens() && flag) {
			end = Integer.parseInt(st.nextToken());
			
			int startD = findParent(start);
			int endD = findParent(end);
			if(startD != endD) flag = false;
			
			start = end;
		}
		
		System.out.println(flag ? "YES" : "NO");
		
	}
}