import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int box[] = new int[N];
        for(int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int nowBox = 0;
        for(int i = 0; i < M; i++) {
            int size = Integer.parseInt(st.nextToken());
            while(nowBox < N && box[nowBox] < size) {
                nowBox += 1;
            }

            box[nowBox] -= size;

        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans += box[i];
        }

        System.out.println(ans);
    }
}
