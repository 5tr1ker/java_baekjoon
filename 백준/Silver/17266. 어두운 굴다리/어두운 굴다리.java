import java.util.*;
import java.io.*;

class Main {

    static int N , M , lamp[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        lamp = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = N;

        while(min < max) {
            int half = (min + max) / 2;

            if(solved(half)) {
                max = half;
            } else {
                min = half + 1;
            }
        }

        System.out.println(max);
    }

    public static boolean solved(int height) {
        int light = 0;

        int left = 0 , right = 0;

        for(int i = 0; i < M; i++) {
            left = lamp[i] - height;
            right = lamp[i] + height;

            if(left > light) {
                return false;
            }

            light = right;
        }

        if(right < N) {
            return false;
        }

        return true;
    }
}