import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem {
	int time;
	int score;
	
	public Problem(int time , int score) {
		this.time = time;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Problem [time=" + time + ", score=" + score + "]";
	}
	
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Problem[] arr = new Problem[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int time = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			arr[i] = new Problem(time, score);
		}
		
		Arrays.sort(arr , new Comparator<Problem>() {

			@Override
			public int compare(Problem o1, Problem o2) {
				if(o1.time == o2.time) return o1.score - o2.score;
				return o1.time - o2.time;
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 0; i < N; i++) {
			if(queue.size() < arr[i].time) {
				queue.offer(arr[i].score);
			} else {
				if(queue.peek() < arr[i].score) {
					queue.poll();
					queue.offer(arr[i].score);
				}
			}
		}
		
		int ans = 0;
		while(!queue.isEmpty())
			ans += queue.poll();
		
		System.out.println(ans);
		
	}
}