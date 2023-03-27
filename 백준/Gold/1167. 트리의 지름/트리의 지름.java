import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int idx;
	int weight;

	public Node(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	}
}

public class Main {

	static ArrayList<Node>[] list;
	static boolean check[];
	static int V, standartVertex = 0;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		check = new boolean[V + 1];
		int maxVertex = 0, maxWeight = 0;

		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());

			while (true) {
				int vertex = Integer.parseInt(st.nextToken());
				if (vertex == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());

				list[index].add(new Node(vertex, weight));
				list[vertex].add(new Node(index, weight));

				if (maxWeight < weight) {
					maxWeight = weight;
					maxVertex = vertex;
				}
			}
		}

		// 가장 먼 거리 찾기
		dfs(maxVertex, 0);

		// 가장 긴 거리에서 DFS
		ans = 0;
		check = new boolean[V + 1];
		dfs(standartVertex, 0);

		System.out.println(ans);
	}

	public static void dfs(int vertex, int weight) {
		check[vertex] = true;
		if (weight > ans) {
			ans = weight;
			standartVertex = vertex;
		}

		for (Node node : list[vertex]) {
			if (!check[node.idx]) {
				dfs(node.idx, weight + node.weight);
			}
		}
	}

}