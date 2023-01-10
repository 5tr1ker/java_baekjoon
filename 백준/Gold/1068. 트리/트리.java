import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static int answer = 0;
	static int removeNode = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		list = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();
		
		int rootNode = 0;
		for(int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			
			if(idx == -1) {
				rootNode = i;
				continue;
			}
			
			list[idx].add(i);
		}
		
		removeNode = Integer.parseInt(br.readLine());
		
		dfs(rootNode);
		
		System.out.println(answer);
	}
	
	public static void dfs(int idx) {
		if(removeNode == idx) return;
		
		if(list[idx].size() <= 0) {
			answer++;
			return;
		}
		
		if(list[idx].size() == 1 && list[idx].get(0) == removeNode) {
			answer++;
			return;
		}
		
		for(int number : list[idx]) {
			dfs(number);
		}
	}
}