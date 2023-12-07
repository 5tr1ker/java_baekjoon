import java.util.*;
import java.io.*;

class Main {

    public static int note_1[] , N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0) {
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            note_1 = new int[N];
            for(int i = 0; i < N; i++) {
                note_1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note_1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++) {
                int next = Integer.parseInt(st.nextToken());

                if(solved(next)) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            sb.deleteCharAt(sb.length() - 1);

            System.out.println(sb);
        }
    }

    public static boolean solved(int index) {
        int start = 0;
        int end = N - 1;

        while(start < end) {
            int half = (start + end) / 2;

            if(note_1[half] >= index) {
                end = half;
            } else {
                start = half + 1;
            }
        }

        return index == note_1[end];
    }

}