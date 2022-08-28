import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean group[];
	static boolean check[];
	
	public static boolean findIndex(int E) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int z = 1; z <= E; z++) {
			if(!check[z]) {
				for(int j = 0; j < list[z].size(); j++) queue.add(list[z].get(j));
			}
			
			while(!queue.isEmpty()) {
				int index = queue.poll();
				int size = list[index].size();
				check[index] = true;
				boolean setGroup = !group[index];
					
				for(int j = 0; j < size; j++) {
					if(check[list[index].get(j)] && group[index] == group[list[index].get(j)]) {
						return false;
					}
					
					if(!check[list[index].get(j)]) {
						group[list[index].get(j)] = setGroup;
						check[list[index].get(j)] = true;
						queue.add(list[index].get(j));
					}
				}
				
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < testCase; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			group = new boolean[V + 1];
			check = new boolean[V + 1];
			
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
			
			if(findIndex(V)) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
