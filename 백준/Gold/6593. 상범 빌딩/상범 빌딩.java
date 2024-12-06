import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int L;
    int R;
    int C;
    int weight;

    public Node(int L, int R, int C, int weight) {
        this.L = L;
        this.R = R;
        this.C = C;
        this.weight = weight;
    }

    public boolean equals(Node node) {
        if(node.L == L && node.R == this.R && node.C == this.C) {
            return true;
        }

        return false;
    }
}

public class Main {

    public static int coorX[] = {0,0,1,-1};
    public static int coorY[] = {1,-1,0,0};
    public static int coorX2[] = {1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            if(st.countTokens() != 3) {
                continue;
            }

            boolean flag = false;

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) {
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            Node exit = null;

            String[][][] map = new String[L][R][C];
            boolean[][][] check = new boolean[L][R][C];
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String input[] = br.readLine().split("");
                    if(input.length != C) {
                        j--;

                        continue;
                    }

                    for(int z = 0; z < C; z++) {
                        map[i][j][z] = input[z];

                        if(input[z].equals("S")) {
                            queue.offer(new Node(i , j , z, 0));
                            check[i][j][z] = true;
                        } else if(input[z].equals("E")) {
                            exit = new Node(i , j , z, 0);
                        }
                    }
                }
            }

            while(!queue.isEmpty() && !flag) {
                Node node = queue.poll();

                // 상하좌우
                for(int i = 0; !flag && i < 4; i++) {
                    int dx = node.R + coorX[i];
                    int dy = node.C + coorY[i];

                    if(dx < 0 || dy < 0 || dx >= R || dy >= C) {
                        continue;
                    }
                    
                    if(exit.equals(new Node(node.L, dx, dy, node.weight))) {
                        System.out.printf("Escaped in %d minute(s).\n" , node.weight + 1);

                        flag = true;
                    };

                    if(map[node.L][dx][dy].equals(".") && !check[node.L][dx][dy]) {
                        check[node.L][dx][dy] = true;
                        
                        queue.offer(new Node(node.L, dx , dy, node.weight + 1));
                    }
                }

                // 층
                for(int i = 0; !flag && i < 2; i++) {
                    int dl = node.L + coorX2[i];

                    if(dl < 0 || dl >= L) {
                        continue;
                    }

                    if(exit.equals(new Node(dl, node.R, node.C, node.weight))) {
                        System.out.printf("Escaped in %d minute(s).\n" , node.weight + 1);

                        flag = true;
                    };

                    if(map[dl][node.R][node.C].equals(".") && !check[dl][node.R][node.C]) {
                        check[dl][node.R][node.C] = true;

                        queue.offer(new Node(dl, node.R , node.C, node.weight + 1));
                    }
                }

            }

            if(!flag) {
                System.out.println("Trapped!");
            }
        }


    }
}
