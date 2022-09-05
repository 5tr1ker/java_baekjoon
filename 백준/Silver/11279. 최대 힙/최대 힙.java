import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> queue = new PriorityQueue<Long>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			Long input = Long.parseLong(br.readLine());
			
			if(input == 0) {
				if(queue.isEmpty()) sb.append(0 + "\n");
				else sb.append(queue.poll() + "\n");
			} else {
				queue.add(input);
			}
		}
		System.out.println(sb);
	}

}