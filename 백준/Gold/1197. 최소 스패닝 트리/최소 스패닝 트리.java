import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Points {
	public int x;
	public int y;
	public int weight;
	
	public Points(int x , int y , int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Points [x=" + x + ", y=" + y + ", weight=" + weight + "]";
	}
};

public class Main {
	
	static public int unionParent[];
	
	public static int findPerent(int idx) {
		if(idx == unionParent[idx])
			return idx;
		
		return unionParent[idx] = findPerent(unionParent[idx]);
	}
	
	public static void union(int x , int y) {
		int px = findPerent(x);
		int py = findPerent(y);
		
		if(px != py) {
			unionParent[px] = py;
		}
	}
	
	public static boolean isSameParent(int x , int y) {
		if(findPerent(x) == findPerent(y)) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Points> links = new ArrayList<Points>();
		unionParent = new int[V + 1];
		for(int i = 1; i <= V; i++)
			unionParent[i] = i;
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			links.add(new Points(x , y , weight));
		}
		
		Collections.sort(links , new Comparator<Points>() {

			@Override
			public int compare(Points o1, Points o2) {
				return o1.weight - o2.weight;
			}
		});
		
		Long totalWeight = 0L;
		int linkCount = 0;
		for(int i = 0; i < E; i++) {
			Points pnt = links.get(i);
			if(linkCount == V - 1) { // 정점-1 개의 간선은 트리의 최대 간선 갯수
				break;
			}
			
			if(!isSameParent(pnt.x, pnt.y)) { // 같은 집합이면 사이클 형성.
				union(pnt.x, pnt.y);
				totalWeight += pnt.weight;
				linkCount++;
			}
		}
		
		System.out.println(totalWeight);
	}
}