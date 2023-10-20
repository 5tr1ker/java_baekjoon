import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static int N , M;
    static ArrayList<Integer>[] map;
    static int sum;
    static boolean check[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            map[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A].add(B);
            map[B].add(A);
        }

        int ans = -1;
        int min = 999999;
        for(int i = 1; i <= N; i++) {
            check = new boolean[N + 1];
            check[i] = true;
            sum = 0;
            bfs(i);

            if(sum < min) {
                ans = i;
                min = sum;
            }
        }

        System.out.println(ans);
    }

    public static void bfs(int index) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{index , 1});

        while(!queue.isEmpty()) {
            int[] idx = queue.poll();

            for(int next : map[idx[0]]) {
                if(!check[next]) {
                    check[next] = true;
                    sum += idx[1];
                    queue.offer(new int[] {next , idx[1] + 1});
                }
            }
        }
    }

}