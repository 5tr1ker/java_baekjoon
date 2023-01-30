import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Point {
	int idx , n;
	
	public Point(int n , int idx) {
		this.n = n;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Point [idx=" + idx + ", n=" + n + "]";
	}
	
	
}

public class Main {
	static int N;
	static int arr[];
	static Point track[];
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int org[] = new int[N];
		for(int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			map.put(idx, i);
			org[i] = idx;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		track = new Point[N];
		for(int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			arr[i] = map.get(idx);
		}
		
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			if(i == 0 || list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
				track[i] = new Point(arr[i], list.size() - 1);
			} else {
				int idx = lowerBound(arr[i]);
				list.set(idx , arr[i]);
				track[i] = new Point(arr[i], idx);
			}
		}
		
		int idx = list.size() - 1;
		
		for(int i = N - 1; i >= 0; i--) {
			if(track[i].idx == idx) {
				list.set(idx, org[track[i].n]);
				idx--;
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append( list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	static public int lowerBound(int idx) {
		int start = 0;
		int end = list.size() - 1;
		
		while(start < end) {
			int half = (start + end) / 2;
			
			if(list.get(half) > idx) {
				end = half;
			} else {
				start = half + 1;
			}
		}
		
		return start;
	}
}