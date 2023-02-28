import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting {
	int idx;
	int start;
	int end;
	
	public Meeting(int idx, int start, int end) {
		this.idx = idx;
		this.start = start;
		this.end = end;
	}
}

class MeetingQueue {
	int idx;
	int time;
	
	public MeetingQueue(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meet = new Meeting[N];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int meetingRoom[] = new int[N + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int idx = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meet[i] = new Meeting(idx, start, end);
		}
		
		Arrays.sort(meet , new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1 , Meeting o2) {
				return o1.start - o2.start;
			}
		});
		
		PriorityQueue<MeetingQueue> queue = new PriorityQueue<MeetingQueue>(new Comparator<MeetingQueue>() {
			@Override
			public int compare(MeetingQueue o1 , MeetingQueue o2) {
				return o1.time - o2.time;
			}
		});
		int roomNumber = 1;
		int total = 0;
		for(int i = 0; i < N; i++) {
			Meeting mt = meet[i];
			
			while(!queue.isEmpty() && queue.peek().time <= mt.start) {
				MeetingQueue mtQueue = queue.poll();
				if(meetingRoom[mt.idx] == 0) {
					meetingRoom[mt.idx] = meetingRoom[mtQueue.idx];
					break;
				}
			}
			
			queue.offer(new MeetingQueue(mt.idx , mt.end));
			total = Math.max(total, queue.size());
			if(meetingRoom[mt.idx] == 0) {
				meetingRoom[mt.idx] = roomNumber++;
			}
		}
		
		sb.append(total).append("\n");
		for(int i = 1; i <= N; i++)
			sb.append(meetingRoom[i]).append("\n");
		
		System.out.println(sb);
		
	}
	
}