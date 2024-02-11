import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(arr[i] , Collections.reverseOrder());
        }

        boolean check[] = new boolean[N + 1];
        check[R] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        int ans[] = new int[N + 1];
        int index = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            ans[now] = index++;

            for(int next : arr[now]) {
                if(!check[next]) {
                    check[next] = true;

                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }

}