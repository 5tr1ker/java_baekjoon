import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static String map[][];
    static int coorX[] = {-1,1,0,0};
    static int coorY[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        map = new String[12][6];

        for(int i = 0; i < 12; i++) {
            String input[] = br.readLine().split("");
            for(int j = 0; j < 6; j++) {
                map[i][j] = input[j];
            }
        }

        int ans = 0;
        while(true) {
            boolean flag = true;

            // 파괴
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(popCheck(i , j)) {
                        pop(i , j);

                        flag = false;
                    }
                }
            }

            if(!flag) {
                for(int z = 0; z < 6; z++) {
                    gravity(z);
                }
                ans++;
            }



            if(flag) break;
        }



        System.out.println(ans);

    }

    public static void gravity(int y) {
        int bottom = 11;
        for(int i = 11; i >= 0; i--) {
            if(!map[i][y].equals(".")) {
                map[bottom][y] = map[i][y];
                if(i != bottom) {
                    map[i][y] = ".";
                }

                bottom--;
            }
        }
    }

    public static void pop(int x , int y) {
        String target = map[x][y];
        Queue<int []> queue = new LinkedList<>();

        queue.offer(new int[] {x , y});
        while(!queue.isEmpty()) {
            int coor[] = queue.poll();
            map[coor[0]][coor[1]] = ".";

            for(int i = 0; i < 4; i++) {
                int dx = coor[0] + coorX[i];
                int dy = coor[1] + coorY[i];

                if(dx < 0 || dy < 0 || dx >= 12 || dy >= 6) continue;

                if(map[dx][dy].equals(target)) {
                    queue.offer(new int[] {dx , dy});
                }
            }
        }
    }

    public static boolean popCheck(int x , int y) {
        if(map[x][y].equals(".")) {
            return false;
        }

        int count = 1;
        String target = map[x][y];
        Queue<int []> queue = new LinkedList<>();
        boolean check[][] = new boolean[12][6];
        queue.offer(new int[] {x , y});
        check[x][y] = true;

        while(!queue.isEmpty()) {
            int coor[] = queue.poll();

            for(int i = 0; i < 4; i++) {
                int dx = coor[0] + coorX[i];
                int dy = coor[1] + coorY[i];

                if(dx < 0 || dy < 0 || dx >= 12 || dy >= 6) continue;

                if(!check[dx][dy] && map[dx][dy].equals(target)) {
                    queue.offer(new int[] {dx , dy});
                    check[dx][dy] = true;
                    count++;
                }
            }
        }

        return count >= 4 ? true : false;
    }

}