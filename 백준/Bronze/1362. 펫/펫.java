import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(o == 0 && w == 0) {
                break;
            }

            while(true) {
                StringTokenizer st2 = new StringTokenizer(br.readLine() , " ");

                String action = st2.nextToken();
                int input = Integer.parseInt(st2.nextToken());

                if(w > 0 && action.equals("F")) {
                    w += input;
                } else if(w > 0 && action.equals("E")) {
                    w -= input;
                } else if(action.equals("#")) {
                    if(w <= 0) {
                        System.out.println(cnt + " RIP");
                    } else if(o * 2 > w && o / 2 < w) {
                        System.out.println(cnt + " :-)");
                    } else {
                        System.out.println(cnt + " :-(");
                    }

                    break;
                }
            }

            cnt++;

        }
    }
}
