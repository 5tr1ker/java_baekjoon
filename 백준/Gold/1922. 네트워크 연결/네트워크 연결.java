import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int start;
	int end;
	int weight;
	
	public Point(int start , int end , int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class Main {
	static int parent[];
	
	static public int findUnion(int idx) {
		if(parent[idx] == idx) return idx;
		
		return parent[idx] = findUnion(parent[idx]);
	}
	
	static public void union(int idx1 , int idx2) {
		int n1 = findUnion(idx1);
		int n2 = findUnion(idx2);
		
		parent[n1] = n2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		Point point[] = new Point[M];
		
		for(int i = 1; i <= N ; i++)
			parent[i] = i;
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			point[i] = new Point(start , end , weight);
		}
		
		Arrays.sort(point , new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});
		
		int weight = 0;
		int idx = 0;
		for(int i = 0; i < M; i++) {
			Point pnt = point[i];
			
			if(idx == N - 1) break;
			
			int startIdx = findUnion(pnt.start);
			int endIdx = findUnion(pnt.end);
			
			if(startIdx != endIdx) {
				idx++;
				weight += pnt.weight;
				union(startIdx, endIdx);
			}
		}
		System.out.println(weight);
	}
	
}