import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LocalDateTime date = LocalDateTime.of(2011,11,11,11,11);
        LocalDateTime date2 = LocalDateTime.of(2011,11,D,H,M);

        long result = (date2.getMinute() + date2.getHour() * 60 + date2.getDayOfMonth() * 1440) - (date.getMinute() + date.getHour() * 60 + date.getDayOfMonth() * 1440);

        if(result < 0) {
            System.out.println(-1);

            return;
        }
        
        System.out.println(result);
    }

}