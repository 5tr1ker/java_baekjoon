import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting {
	int time;
	boolean isStart;
	
	public Meeting(int time, boolean isStart) {
		this.time = time;
		this.isStart = isStart;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(new Comparator<Meeting>() {
			
			@Override
			public int compare(Meeting o1 , Meeting o2) {
				return o1.time - o2.time;
			}
		});
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			queue.offer(new Meeting(start , true));
			queue.offer(new Meeting(end , false));
		}
		
		int ans = 0;
		int cnt = 0;
		while(!queue.isEmpty()) {
			Meeting mt = queue.poll();
			
			if(mt.isStart) {
				cnt++;
				ans = Math.max(ans, cnt);
			} else {
				cnt--;
			}
		}
		
		System.out.println(ans);
	}
	
}