import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		
		for(int i = 0; i < N; i++) {
			Long input = Long.parseLong(br.readLine());
			
			if(input == 0) {
				if(queue.isEmpty()) System.out.println(0); 
				else System.out.println(queue.poll());
			} else {
				queue.add(input);
			}
		}
	}
}