import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Node {
	int time;
	int deadLine;
	
	public Node(int time, int deadLine) {
		this.time = time;
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "Node [time=" + time + ", deadLine=" + deadLine + "]";
	}
	
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node arr[] = new Node[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int time = Integer.parseInt(st.nextToken());
			int deadLine = Integer.parseInt(st.nextToken());
			arr[i] = new Node(time, deadLine);
		}
		
		Arrays.sort(arr , new Comparator<Node>() {
			
			@Override
			public int compare(Node o1 , Node o2) {
				return o2.deadLine - o1.deadLine;
			}
		});
		
		//Greedy
		int today = arr[0].deadLine - (arr[0].time - 1);
		int ans = 0;
		for(int i = 1; i < N; i++) {
			Node nd = arr[i];
			
			ans = Math.max(ans, today - nd.deadLine - 1);
			today = Math.min(nd.deadLine , today - 1); // 과제 마감일 수정
			today -= (nd.time - 1); // 과제를 시작해야 하는 시간
		}
		
		System.out.println(today - 1);
		
	}

}