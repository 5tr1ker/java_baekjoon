import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Planet {
	int number , x , y , z;

	public Planet(int number , int x, int y, int z) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Node {
	int x , y , weight;
	
	public Node(int x, int y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", weight=" + weight + "]";
	}
	
	
}

public class Main {
	
	static ArrayList<Node> nodeList;
	static Planet arr[];
	static int N;
	static int parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Planet[N];
		parent = new int[N];
		nodeList = new ArrayList<Node>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			arr[i] = new Planet(i, x, y, z);
			parent[i] = i;
		}
		
		// x 정렬
		Arrays.sort(arr , new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.x - o2.x;
			}
		});
		calculateWeight();
		
		// y 정렬
		Arrays.sort(arr , new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.y - o2.y;
			}
		});
		calculateWeight();
		
		// z 정렬
		Arrays.sort(arr , new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.z - o2.z;
			}
		});
		calculateWeight();
		
		// 값 정렬
		Collections.sort(nodeList , new Comparator<Node>() {
			@Override
			public int compare(Node o1 , Node o2) {
				return o1.weight - o2.weight;
			}
		});
		
		int ans = 0;
		for(Node nd : nodeList) {
			if(!isSameParent(nd.x, nd.y)) {
				union(nd.x , nd.y);
				ans += nd.weight;
			}
		}
		System.out.println(ans);
	}
	
	public static void calculateWeight() {
		for(int i = 0; i < N - 1 ; i++) {
			int min = Math.min(Math.abs(arr[i].x - arr[i + 1].x), Math.min(Math.abs(arr[i].y - arr[i + 1].y), Math.abs(arr[i].z - arr[i + 1].z)));
			nodeList.add(new Node(arr[i].number, arr[i + 1].number, min));
		}
	}
	
	public static int findParent(int idx) {
		if(parent[idx] == idx) return idx;
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	public static void union(int idx1 , int idx2) {
		int d1 = findParent(idx1);
		int d2 = findParent(idx2);
		
		if(d1 != d2) {
			parent[d1] = d2;
		}
	}
	
	public static boolean isSameParent(int idx1 , int idx2) {
		return findParent(idx1) == findParent(idx2);
	}
}