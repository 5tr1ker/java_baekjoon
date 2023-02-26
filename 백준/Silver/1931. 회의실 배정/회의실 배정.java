import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Meeting {
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]";
	}
	
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Meeting[] meet = new Meeting[N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meet[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meet , new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1 , Meeting o2) {
				if(o1.end == o2.end) return o1.start - o2.start;
				
				return o1.end - o2.end;
			}
		});
		
		int ans = 0;
		int recent = 0;
		for(int i = 0; i < N ;i++) {
			Meeting mt = meet[i];
			
			if(recent <= mt.start) {
				ans += 1;
				recent = mt.end;
			}
		}
		
		System.out.println(ans);
		
	}
	
}