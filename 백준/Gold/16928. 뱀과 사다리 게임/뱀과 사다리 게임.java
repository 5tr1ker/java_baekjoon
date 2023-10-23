import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int index;
    int count;

    public Node(int index , int count) {
        this.index = index;
        this.count = count;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int map[] = new int[101];
        boolean check[] = new boolean[101];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(map[1] == 0 ? new Node(1 , 0) : new Node(map[1] , 0));
        check[1] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.index == 100) {
                System.out.println(node.count);
                return;
            }

            for(int i = 1; i <= 6; i++) {

                if(node.index + i > 100) break;

                int next = map[node.index + i] == 0 ? node.index + i : map[node.index + i];

                if(!check[next]) {
                    queue.offer(new Node(next , node.count + 1));
                    check[next] = true;
                }
            }
        }
    }
}