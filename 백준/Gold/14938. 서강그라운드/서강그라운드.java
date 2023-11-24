import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Node {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}

class Main {

    static int n, m, r , items[] , INF = 100_000_000;
    static ArrayList<Node>[] maps;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        maps = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            maps[i] = new ArrayList<>();
        }

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            maps[start].add(new Node(end, weight));
            maps[end].add(new Node(start, weight));
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans , dijkstra(i, 0));
        }

        System.out.println(ans);
    }

    // 시간 복잡도 O(NLogN(N + M))
    public static int dijkstra(int next, int weight) {
        int result = 0;
        int weightMap[] = new int[n + 1];
        Arrays.fill(weightMap , INF);
        weightMap[next] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((n1 , n2) -> n1.weight - n2.weight);
        queue.offer(new Node(next , weight));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node nextNode : maps[node.index]) {
                if(weightMap[node.index] + nextNode.weight < weightMap[nextNode.index]) {
                    weightMap[nextNode.index] = weightMap[node.index]  + nextNode.weight;

                    queue.offer(new Node(nextNode.index , weightMap[node.index]  + nextNode.weight));
                }
            }
        }

        for(int i = 1; i <= n ; i++) {
            if(weightMap[i] <= m) {
                result += items[i];
            }
        }

        return result;
    }


}