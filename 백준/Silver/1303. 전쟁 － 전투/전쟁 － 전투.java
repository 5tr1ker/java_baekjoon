import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x , y;

    public Node(int x , int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int coorX[] = {-1,1,0,0};
    static int coorY[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean map[][] = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str[] = br.readLine().split("");

            for(int j = 0; j < M; j++) {
                if(str[j].equals("W")) {
                    map[i][j] = true;
                }
            }
        }

        boolean check[][] = new boolean[N][M];
        int enemy = 0;
        int friendly = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!check[i][j]) {
                    Queue<Node> queue = new LinkedList<>();
                    boolean target = map[i][j];
                    queue.offer(new Node(i , j));
                    int count = 1;
                    check[i][j] = true;

                    while(!queue.isEmpty()) {
                        Node node = queue.poll();

                        for(int z = 0; z < 4; z++) {
                            int dx = node.x + coorX[z];
                            int dy = node.y + coorY[z];

                            if(dx >= N || dx < 0 || dy >= M || dy < 0 || check[dx][dy]) {
                                continue;
                            }

                            if(map[dx][dy] == target) {
                                count += 1;

                                queue.offer(new Node(dx, dy));
                                check[dx][dy] = true;
                            }
                        }
                    }

                    if(target) {
                        friendly += Math.pow(count , 2);

                        continue;
                    }

                    enemy += Math.pow(count , 2);
                }
            }
        }

        System.out.println(friendly + " " + enemy);
    }

}