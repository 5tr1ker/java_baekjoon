import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int time[] = new int[100_001];

        int ans = 999_999;
        int cnt = 0;

        if(N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        queue.offer(N);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == K) {
                ans = time[now];
                cnt++;
            }

            if(time[now] > ans) {
                break;
            }

            for(int i = 0; i < 3; i++) {
                int next = now;

                if(i == 0) next += 1;
                else if(i == 1) next -= 1;
                else if(i == 2) next *= 2;

                if(next < 0 || next > 100000) continue;
                if(time[next] == 0 || time[next] >= time[now] + 1) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }

        System.out.println(ans + "\n" + cnt);
    }
}