import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N + 1];
        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int now = arr[left];

        int ans = 0;
        while(right < N) {
            if(now == M) {
                ans++;

                right++;
                now += arr[right];

                continue;
            }

            if(left + 1 > right || now < M) {
                right++;
                now += arr[right];

                continue;
            }

            if(now > M) {
                now -= arr[left];
                left++;
            }
        }

        System.out.println(ans);
    }
}