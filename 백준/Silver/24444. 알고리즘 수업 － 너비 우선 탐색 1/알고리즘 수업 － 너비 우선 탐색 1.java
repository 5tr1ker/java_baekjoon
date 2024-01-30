import java.io.*;
import java.util.*;
import java.lang.*;

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
            st = new StringTokenizer(br.readLine() , " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        int result[] = new int[N + 1];
        boolean check[] = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        int nextIndex = 1;
        result[R] = nextIndex++;
        check[R] = true;

        while(!queue.isEmpty()) {
            int index = queue.poll();

            for(int next : arr[index]) {
                if(!check[next]) {
                    queue.offer(next);

                    result[next] = nextIndex++;
                    check[next] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }

    }

}