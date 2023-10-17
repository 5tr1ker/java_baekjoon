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
                int nowIdx = now;

                if(i == 0) nowIdx += 1;
                else if(i == 1) nowIdx -= 1;
                else nowIdx *= 2;

                if(nowIdx < 0 || nowIdx > 100000) continue;

                if(time[nowIdx] == 0 || time[nowIdx] >= time[now] + 1) {
                    queue.offer(nowIdx);
                    time[nowIdx] = time[now] + 1;
                }

            }

        }

        System.out.println(ans + "\n" + cnt);
    }
}