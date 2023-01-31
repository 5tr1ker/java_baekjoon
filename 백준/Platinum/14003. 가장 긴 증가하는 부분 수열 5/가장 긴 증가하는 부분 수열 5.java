import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int n , idx;
	
	public Point(int n , int idx) {
		this.n = n;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Point [n=" + n + ", idx=" + idx + "]";
	}
	
	
}

public class Main {
	
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int arr[] = new int[N];
		Point trace[] = new Point[N];
		
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list.add(arr[0]);
		trace[0] = new Point(0 , arr[0]);
		
		for(int i = 1; i < N; i++) {
			if(list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
				trace[i] = new Point(list.size() - 1, arr[i]);
			} else {
				int idx = lowerBound(arr[i]);
				list.set(idx , arr[i]);
				trace[i] = new Point(idx , arr[i]);
			}
		}
		
		// trace 단계
		StringBuilder sb = new StringBuilder();
		int idx = list.size() - 1;
		sb.append(list.size()).append("\n");
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = N - 1; i >= 0 ; i--) {
			if(idx == trace[i].n) {
				stack.push(trace[i].idx);
				idx--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	public static int lowerBound(int idx) {
		int start = 0;
		int end = list.size() - 1;
		
		while(end > start) {
			int half = (start + end) / 2;
			
			if(list.get(half) < idx) {
				start = half + 1;
			} else {
				end = half;
			}
		}
		
		return start;
	}
}