import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Computer = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int graph[][] = new int[Computer + 1][Computer + 1];
		boolean check[] = new boolean[Computer + 1];
		int count = 0;
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			graph[m][n] = graph[n][m] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		check[1] = true;
		int index;
		while(!queue.isEmpty()) {
			index = queue.poll();
			for(int j = 1; j <= Computer; j++) {
				if(graph[index][j] == 1 && !check[j]) {
					check[j] = true;
					queue.add(j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}