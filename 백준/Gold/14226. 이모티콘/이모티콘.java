import java.io.*;
import java.lang.*;
import java.util.*;

class Node {

    int total;
    int clipBoard;
    int time;

    public Node(int total, int clipBoard , int time) {
        this.total = total;
        this.time = time;
        this.clipBoard = clipBoard;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        boolean check[][] = new boolean[1001][1001]; // [클립보드][전체]

        queue.offer(new Node(1 , 0 , 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.total == S) {
                System.out.println(node.time);
                return;
            }

            // 클립 보드 복사
            queue.offer(new Node(node.total , node.total, node.time + 1));

            // 클립보드 붙여 넣기
            if(node.total + node.clipBoard < 1001 && node.clipBoard != 0 && !check[node.clipBoard][node.total + node.clipBoard]) {
                queue.offer(new Node(node.total + node.clipBoard  , node.clipBoard , node.time + 1));
                check[node.clipBoard][node.total + node.clipBoard] = true;
            }

            // 하나 빼기
            if(node.total - 1 > 0 && !check[node.clipBoard][node.total - 1]) {
                queue.offer(new Node(node.total - 1 , node.clipBoard , node.time + 1));
                check[node.clipBoard][node.total - 1] = true;
            }

        }

    }
}