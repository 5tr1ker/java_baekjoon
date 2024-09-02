import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int ans = 0 ;
            for(int j = 0; j < 5; j++) {
                ans = Math.max(ans, Integer.parseInt(st.nextToken()));
            }

            System.out.printf("Case #%d: %d\n" , i , ans);
        }

    }

}