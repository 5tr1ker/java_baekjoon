import java.math.BigInteger;
import java.util.*;
import java.io.*;


class Main {

    static boolean check[];
    static int ans[] , N , next = 1;
    static ArrayList<Integer>[]maps;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        ans = new int[N + 1];
        maps = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
             maps[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            maps[u].add(v);
            maps[v].add(u);
        }

        check[R] = true;
        ans[R] = next++;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int index) {
        Collections.sort(maps[index]);

        for(int nextIndex : maps[index]) {
            if(!check[nextIndex]) {
                check[nextIndex] = true;
                ans[nextIndex] = next++;

                dfs(nextIndex);
            }
        }
    }


}