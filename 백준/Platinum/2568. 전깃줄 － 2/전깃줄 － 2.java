import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int start , end;
	
	public Point(int start , int end) {
		this.start = start;
		this.end = end;
	}
	
}

class Trace {
	int idx;
	int cnt;
	
	public Trace(int idx , int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Trace [idx=" + idx + ", cnt=" + cnt + "]";
	}
	
	
}

public class Main {
	
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> arr = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr.add(new Point(start , end));
		}
		
		Collections.sort(arr , new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.start - o2.start;
			}
		});
		
		result = new ArrayList<Integer>();
		Trace trace[] = new Trace[N];
		boolean check[] = new boolean[N];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			Point data = arr.get(i);
			
			if(i == 0 || result.get(result.size() - 1) < data.end) {
				result.add(data.end);
				trace[i] = new Trace(result.size() - 1 , data.end);
			} else {
				int idx = lowerBound(data.end);
				result.set(idx , data.end);
				trace[i] = new Trace(idx , data.end);
			}
		}
		
		int tmp = result.size() - 1;
		for(int i = N - 1; i >= 0; i--) {
			if(trace[i].idx == tmp) {
				check[i] = true;
				tmp--;
			}
		}
		
		sb.append(N - result.size()).append("\n");
		for(int i = 0; i < N; i++) {
			if(!check[i]) {
				sb.append(arr.get(i).start).append("\n");
			}
		}
		
		System.out.println(sb);
			
	}
	
	public static int lowerBound(int idx) {
		int start = 0;
		int end = result.size() - 1;
		
		while(start < end) {
			int half = (start + end) / 2;
			
			if(result.get(half) > idx) {
				end = half;
			} else {
				start = half + 1;
			}
		}
		
		return start;
	}
}