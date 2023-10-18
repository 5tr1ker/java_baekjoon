import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int x;
    int y;
    int time;

    public Node(int x , int y , int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Main {

    public static int coorX[] = {0,0,-1,1};
    public static int coorY[] = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        String map[][] = new String[C][R];

        Queue<Node> fire = new LinkedList<>();
        int time[][] = new int[C][R];
        boolean fireCheck[][] = new boolean[C][R];

        Queue<Node> man = new LinkedList<>();
        boolean manCheck[][] = new boolean[C][R];

        for(int i = 0; i < C; i++) {
            String input[] = br.readLine().split("");

            for(int j = 0; j < R; j++) {
                map[i][j] = input[j];

                if(map[i][j].equals("F")) {
                    fire.offer(new Node(i , j , 0));
                    time[i][j] = 999_999;
                    fireCheck[i][j] = true;
                }

                if(map[i][j].equals("J")) {
                    man.offer(new Node(i , j , 0));
                    manCheck[i][j] = true;
                }
            }
        }

        // 불 확산
        while(!fire.isEmpty()) {
            Node node = fire.poll();

            for(int i = 0; i < 4; i++) {
                int dx = node.x + coorX[i];
                int dy = node.y + coorY[i];

                if(dx < 0 || dy < 0 || dy >= R || dx >= C) continue;

                if(map[dx][dy].equals(".") && !fireCheck[dx][dy]) {
                    time[dx][dy] = node.time + 1;
                    fireCheck[dx][dy] = true;
                    fire.offer(new Node(dx , dy , node.time + 1));
                }
            }
        }

        // 민재 탈출
        while(!man.isEmpty()) {
            Node node = man.poll();

            for(int i = 0; i < 4; i++) {
                int dx = node.x + coorX[i];
                int dy = node.y + coorY[i];

                if(dx < 0 || dy < 0 || dy >= R || dx >= C) { // 탈출
                    System.out.println(node.time + 1);
                    return;
                }

                if(map[dx][dy].equals(".") && !manCheck[dx][dy] && (time[dx][dy] == 0 || node.time + 1 < time[dx][dy])) {
                    man.offer(new Node(dx , dy , node.time + 1));
                    manCheck[dx][dy] = true;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}