import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            HashSet<Integer> note_1 = new HashSet<>();
            for(int i = 0; i < N; i++) {
                note_1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++) {
                int next = Integer.parseInt(st.nextToken());

                if(note_1.contains(next)) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            sb.deleteCharAt(sb.length() - 1);

            System.out.println(sb);
        }
    }

}