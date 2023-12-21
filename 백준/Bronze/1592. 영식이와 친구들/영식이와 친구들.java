import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 1];
        int now = 1;
        int count = 0;

        while(true) {
            if(now > N) {
                now -= N;
            }else if(now <= 0) {
                now += N;
            }

            arr[now] += 1;

            if(arr[now] >= M) {
                System.out.println(count);

                return;
            }

            if(arr[now] % 2 == 0) {
                now += L;
            } else {
                now -= L;
            }

            count += 1;
        }
    }
}
