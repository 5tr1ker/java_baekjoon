import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();	// 양수 저장
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(Collections.reverseOrder()); 	// 음수 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) { // 출력
				if(queue1.isEmpty() && queue2.isEmpty()) {
					sb.append("0\n"); // 둘다 비었을 때
					continue;
				}
				else if(queue1.isEmpty()) {
					sb.append(queue2.poll() + "\n"); // 양수가 null
					continue;
				}
				else if(queue2.isEmpty()) {
					sb.append(queue1.poll() + "\n"); // 음수가 null
					continue;
				}
				int data_1 = queue1.peek();
				int data_2 = queue2.peek(); // 음수
				
				if(Math.abs(data_2) == data_1) { // 같은 크기일 때
					sb.append(queue2.poll() + "\n");
				} else if(Math.abs(data_2) > data_1) { // 절댓값 비교
					sb.append(queue1.poll() + "\n");
				} else {
					sb.append(queue2.poll() + "\n");
				}

			} else { // 값 대입
				if(input < 0) { // 음수일때
					queue2.add(input);
				} else {	// 양수
					queue1.add(input);
				}
			}
		}
		System.out.println(sb);
	}

}