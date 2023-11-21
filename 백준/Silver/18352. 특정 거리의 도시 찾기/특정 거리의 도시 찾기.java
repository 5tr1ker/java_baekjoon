import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Node {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public String toString() {
        return "[Node -> " + index + " / time -> " + time + " ]";
    }
}

class Main {

    static boolean visited[];
    static int N , M , K , X;
    final static int INF = 100_000_000;
    static int time[];
    static ArrayList<Integer>[] maps;
    static PriorityQueue<Node> queue = new PriorityQueue<>((n1 , n2) -> n1.time - n2.time);


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        maps = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            maps[start].add(end);
        }

        // 다익스트라
        visited = new boolean[N + 1];
        time = new int[N + 1];
        Arrays.fill(time , INF);
        time[X] = 0;
        queue.add(new Node(X , 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            Dijkstra(node);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(time[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    public static void Dijkstra(Node node) {
        visited[node.index] = true;
        int nextTime = time[node.index] + 1;

        if(nextTime > K) return;

        for(int next : maps[node.index]) {
            if(time[next] > nextTime) {
                time[next] = nextTime;
                queue.offer(new Node(next , nextTime));
            }
        }
    }
}