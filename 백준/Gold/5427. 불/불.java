import java.util.*;
import java.io.*;

class Node {
    int x , y , time;

    public Node(int x , int y , int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main
{

    public static int coorX[] = {0,0,-1,1};
    public static int coorY[] = {1,-1,0,0};

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            String map[][] = new String[h][w];
            Queue<Node> fireQueue = new LinkedList<>();
            Queue<Node> escapeQueue = new LinkedList<>();

            for(int i = 0; i < h; i++) {
                String []input = br.readLine().split("");

                for(int j = 0; j < w; j++) {
                    map[i][j] = input[j];
                    if(map[i][j].equals("*")) {
                        fireQueue.offer(new Node(i , j , 0));
                    }

                    if(map[i][j].equals("@")) {
                        escapeQueue.offer(new Node(i , j , 0));
                    }
                }
            }

            int fire[][] = new int[h][w];
            while(!fireQueue.isEmpty()) {
                Node node = fireQueue.poll();

                for(int i = 0; i < 4; i++) {
                    int dx = node.x + coorX[i];
                    int dy = node.y + coorY[i];

                    if(dx < 0 || dy < 0 || dy >= w || dx >= h || map[dx][dy].equals("#")) continue;

                    if(fire[dx][dy] == 0) {
                        fireQueue.offer(new Node(dx , dy , node.time + 1));
                        fire[dx][dy] = node.time + 1;
                    }
                }
            }

            boolean flag = false;
            boolean check[][] = new boolean[h][w];
            while(!escapeQueue.isEmpty() && !flag) {
                Node node = escapeQueue.poll();

                for(int i = 0; i < 4; i++) {
                    int dx = node.x + coorX[i];
                    int dy = node.y + coorY[i];

                    if(dx < 0 || dy < 0 || dy >= w || dx >= h) {
                        sb.append(node.time + 1).append("\n");

                        flag = true;
                        break;
                    }

                    if(map[dx][dy].equals("#") || map[dx][dy].equals("*") || check[dx][dy]) continue;

                    if(fire[dx][dy] == 0 || fire[dx][dy] > node.time + 1) {
                        check[dx][dy] = true;
                        escapeQueue.offer(new Node(dx,dy,node.time + 1));
                    }
                }
            }

            if(!flag) {
                sb.append("IMPOSSIBLE").append("\n");
            }

        }

        System.out.println(sb);

    }
}