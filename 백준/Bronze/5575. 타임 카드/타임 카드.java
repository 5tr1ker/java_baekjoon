import java.io.*;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            LocalTime time = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            time = time.minusHours(hour);
            time = time.minusMinutes(minute);
            time = time.minusSeconds(second);
            System.out.printf("%d %d %d \n" , time.getHour(), time.getMinute(), time.getSecond());
        }

    }

}