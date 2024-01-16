import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int x , y , weight;

    public Node(int x , int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

public class Main {

    static int coorX[] = {-1,1,0,0};
    static int coorY[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        int result[][] = new int[N][M];
        boolean check[][] = new boolean[N][M];

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int dx = node.x + coorX[i];
                int dy = node.y + coorY[i];

                if(dx < 0 || dx >= N || dy < 0 || dy >= M || check[dx][dy]) {
                    continue;
                }

                if(arr[dx][dy] == 1) {
                    result[dx][dy] = node.weight + 1;
                    check[dx][dy] = true;

                    queue.offer(new Node(dx, dy, node.weight + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(check[i][j] && arr[i][j] == 1) {
                    sb.append(result[i][j]).append(" ");
                } else if(!check[i][j] && arr[i][j] == 1) {
                    sb.append("-1 ");
                } else{
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}