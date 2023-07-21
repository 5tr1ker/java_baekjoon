import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int arr[][];
    public static boolean check[][];
    public static int coorX[] = {1, -1, 0, 0};
    public static int coorY[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    cnt ++;
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                    int area = 1;

                    while (!queue.isEmpty()) {
                        Point pnt = queue.poll();

                        for (int z = 0; z < 4; z++) {
                            int dx = pnt.x + coorX[z];
                            int dy = pnt.y + coorY[z];

                            if(dx < 0 || dy < 0 || dx >= N || dy >= M) {
                                continue;
                            }

                            if(arr[dx][dy] == 1 && !check[dx][dy]) {
                                check[dx][dy] = true;
                                queue.offer(new Point(dx , dy));
                                area++;
                            }
                        }
                    }
                    ans = Math.max(ans , area);
                }
            }
        }

        System.out.println(cnt + "\n" + ans);
    }
}