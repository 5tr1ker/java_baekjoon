import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < M; i++) {
			Long idx1 = queue.poll();
			Long idx2 = queue.poll();
			queue.offer(idx1 + idx2);
			queue.offer(idx1 + idx2);
		}
		
		Long count = 0L;
		while(!queue.isEmpty()) {
			count += queue.poll();
		}
		
		System.out.println(count);
	}

}