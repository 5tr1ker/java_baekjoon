import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y , save;

    public Node(int x , int y, int save) {
        this.x = x;
        this.y = y;
        this.save = save;
    }
}

public class Main {

    public static int coorX[] = {-1,-1,-1,0,0,1,1,1};
    public static int coorY[] = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean map[][] = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            for(int j = 0; j < M; j++) {
                int idx = Integer.parseInt(st.nextToken());

                if(idx == 1) {
                    map[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j]) {
                    continue;
                }

                Queue<Node> queue = new LinkedList<>();

                queue.offer(new Node(i , j , 0));
                boolean check[][] = new boolean[N][M];
                check[i][j] = true;
                int max = 0;

                while(!queue.isEmpty()) {
                    Node node = queue.poll();

                    for(int z = 0; z < 8; z++) {
                        int dx = node.x + coorX[z];
                        int dy = node.y + coorY[z];

                        if(dx >= N || dx < 0 || dy < 0 || dy >= M || check[dx][dy]) {
                            continue;
                        }

                        if(map[dx][dy]) {
                            max = node.save + 1;

                            queue.clear();
                            break;
                        }

                        check[dx][dy] = true;
                        queue.offer(new Node(dx, dy, node.save + 1));
                    }
                }

                ans = Math.max(ans , max);
            }
        }

        System.out.println(ans);

    }

}