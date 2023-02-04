import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        while(N-- > 1) {
        	queue.offer(Integer.parseInt(br.readLine()));
        }
        
        int count = 0;
        while(!queue.isEmpty() && queue.peek() >= A) {
        	count++;
        	A++;
        	queue.offer(queue.poll() - 1);
        }
        
        System.out.println(count);
    }


}