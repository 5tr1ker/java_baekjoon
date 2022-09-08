import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1 , o2) -> {
			int absO1 = Math.abs(o1);
			int absO2 = Math.abs(o2);
			
			if(absO1 == absO2) return o1 > o2 ? 1 : -1;
			return absO1 - absO2;
		});
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) { // 출력
				if(queue.isEmpty()) {
					sb.append("0\n"); // 둘다 비었을 때
				} else {
					sb.append(queue.poll() + "\n");
				}
			} else { // 값 대입
				queue.add(input);
			}
		}
		System.out.println(sb);
	}

}
