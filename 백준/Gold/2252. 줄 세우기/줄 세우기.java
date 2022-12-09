import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int increase[] = new int[N + 1];
		StringBuilder sb = new StringBuilder();
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++) {
			map.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.get(x).add(y);
			increase[y]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(increase[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int element : map.get(now)) {
				increase[element]--;
				
				if(increase[element] == 0)
					queue.offer(element);
			}
		}
		
		System.out.println(sb);
		
	}

}