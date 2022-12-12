import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public int parent[];
	
	public static int find_parent(int idx) {
		if(parent[idx] == idx) return idx;
		
		return parent[idx] = find_parent(parent[idx]);
	}
	
	public static void union(int idx1 , int idx2) {
		int f1 = find_parent(idx1);
		int f2 = find_parent(idx2);
		
		if(f1 != f2) {
			parent[f1] = f2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		for(int i = 0; i < N; i++)
			parent[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			int f1 = find_parent(idx1);
			int f2 = find_parent(idx2);
			
			if(f1 == f2) {
				System.out.println(i + 1);
				return;
			} else {
				union(f1 , f2);
			}
		}
		
		System.out.println(0);
	}
}