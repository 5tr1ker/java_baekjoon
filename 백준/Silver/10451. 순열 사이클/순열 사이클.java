import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            int ans = 1;
            int score[] = new int[N + 1];
            int map[] = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                if(score[i] == 0) {
                    queue.offer(map[i]);
                    score[i] = ans;

                    while(!queue.isEmpty()) {
                        int next = queue.poll();

                        if(score[next] == 0) {
                            score[next] = ans;

                            queue.offer(map[next]);
                        }
                    }

                    ans++;
                }
            }

            System.out.println(ans - 1);
        }
    }
}