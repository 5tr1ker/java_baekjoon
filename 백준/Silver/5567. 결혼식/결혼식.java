import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Node {
    int index , depth;

    public Node(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }
}

class Main {

    static int N , ans = 0;
    static ArrayList<Integer> maps[];
    static boolean check[];


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        maps = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            maps[start].add(end);
            maps[end].add(start);
        }

        check = new boolean[N + 1];
        check[1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1 , 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.depth <= 2) {
                ans++;
            } else {
                continue;
            }

            for(int next : maps[node.index]) {
                if(!check[next]) {
                    check[next] = true;
                    queue.offer(new Node(next , node.depth + 1));
                }
            }
        }

        System.out.println(ans - 1);
    }
}