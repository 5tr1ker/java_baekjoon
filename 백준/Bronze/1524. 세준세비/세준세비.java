import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(st.countTokens() <= 1) {
                T ++;
                continue;
            }

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> sejoon = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                sejoon.add(Integer.parseInt(st.nextToken()));
            }

            PriorityQueue<Integer> sebi = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                sebi.add(Integer.parseInt(st.nextToken()));
            }

            while(true) {
                if(sejoon.isEmpty() && sebi.isEmpty()) {
                    sb.append("C").append("\n");

                    break;
                } else if(sejoon.isEmpty()) {
                    sb.append("B").append("\n");

                    break;
                } else if(sebi.isEmpty()) {
                    sb.append("S").append("\n");

                    break;
                }

                int sejoonPK = sejoon.peek();
                int sebiPK = sebi.peek();
                if(sejoonPK > sebiPK) {
                    sebi.poll();
                } else if(sejoonPK < sebiPK) {
                    sejoon.poll();
                } else {
                    sebi.poll();
                }
            }

        }

        System.out.println(sb);

    }

}