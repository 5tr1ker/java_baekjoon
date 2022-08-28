import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int group[];
	
	public static void findIndex(int E) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int z = 1; z <= E; z++) {
			if(group[z] == 0) {
				queue.add(z);
				group[z] = 1;
			}
			
			while(!queue.isEmpty()) {
				int index = queue.poll();
					
				for(int j = 0; j < list[index].size() ; j++) {
					
					if(group[list[index].get(j)] == 0) {
						queue.add(list[index].get(j));
						if(group[index] == 2) group[list[index].get(j)] = 1;
						if(group[index] == 1) group[list[index].get(j)] = 2;
					}
					
					if(group[index] == group[list[index].get(j)]) {
						System.out.println("NO");
						return;
					}
					
				}
				
			}
		}
		
		System.out.println("YES");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < testCase; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			group = new int[V + 1];
			
			for(int i = 1; i <= V; i++) list[i] = new ArrayList<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				
				while(st.hasMoreTokens()) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					list[x].add(y);
					list[y].add(x);
				}
				
			}
			
			findIndex(V);
			
		}
	}
}