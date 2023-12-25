import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        HashSet<Integer> hash = new HashSet<>();

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            if(hash.contains(next)) {
                ans += 1;

            }
            hash.add(next);
        }

        System.out.println(ans);
    }
}
