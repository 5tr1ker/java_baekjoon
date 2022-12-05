import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pointer {
	int x;
	int y;
	int weight;
	
	public Pointer(int x , int y , int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Pointer [x=" + x + ", y=" + y + ", weight=" + weight + "]";
	}
	
	
}

public class Main {
	
	public static int parent[];
	
	public static int findParent(int idx) {
		if(idx == parent[idx]) return idx;
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	public static void union(int idx1 , int idx2) {
		int d1 = findParent(idx1);
		int d2 = findParent(idx2);
		
		if(d1 != d2) {
			parent[d1] = d2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		
		ArrayList<Pointer> list = new ArrayList<Pointer>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Pointer(x , y , weight));
		}
		
		Collections.sort(list , new Comparator<Pointer>() {

			@Override
			public int compare(Pointer o1, Pointer o2) {
				return o1.weight - o2.weight;
			}
		});
		
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		int total = 0;
		int findline = 0;
		
		for(int i = 0; i < M ; i++) {
			if(findline == N - 2) break;
			
			Pointer pt = list.get(i);
			int px = findParent(pt.x);
			int py = findParent(pt.y);
			
			if(px != py) {
				union(px, py);
				total += pt.weight;
				findline++;
			}
		}
		
		System.out.println(total);
	}

}