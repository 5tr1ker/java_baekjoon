import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static int coorX[] = {0,0,-1,1};
    static int coorY[] = {-1,1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean trash[][] = new boolean[N][M];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trash[r - 1][c - 1] = true;
        }

        boolean check[][] = new boolean[N][M];
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(trash[i][j] && !check[i][j]) {

                    Queue<int []> queue = new LinkedList<>();
                    queue.offer(new int[] {i , j});
check[i][j] = true;
                    int count = 1;

                    while(!queue.isEmpty()) {
                        int input[] = queue.poll();

for(int z= 0 ; z < 4 ; z++) {
    int dx = input[0] + coorX[z];
    int dy = input [ 1] + coorY[z];

    if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;

    if(trash[dx][dy] && !check[dx][dy]) {
        count++;
        queue.offer(new int[] {dx,dy});
        check[dx][dy] = true;
    }
}
                    }
ans = Math.max(count , ans);
                }
            }
        }

        System.out.println(ans);
    }

}