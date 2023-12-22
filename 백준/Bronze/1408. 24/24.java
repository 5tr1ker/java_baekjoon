import java.time.LocalTime;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nowTime[] = br.readLine().split(":");
        String startTime[] = br.readLine().split(":");

        int hour = Integer.parseInt(startTime[0]);
        int minute = Integer.parseInt(startTime[1]);
        int second = Integer.parseInt(startTime[2]);
        LocalTime time = LocalTime.of(hour, minute, second);

        time = time.minusHours(Integer.parseInt(nowTime[0]));
        time = time.minusMinutes(Integer.parseInt(nowTime[1]));
        time = time.minusSeconds(Integer.parseInt(nowTime[2]));

        StringBuilder sb = new StringBuilder();
        sb.append("00").append(time.getHour());
        sb.delete(0, sb.length() - 2);

        sb.append(":00").append(time.getMinute());
        sb.delete(3, sb.length() - 2);

        sb.append(":00").append(time.getSecond());
        sb.delete(6, sb.length() - 2);

        System.out.println(sb);
    }
}
