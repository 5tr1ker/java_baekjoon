import java.io.*;
import java.time.LocalTime;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        LocalTime time = LocalTime.of(A , B , C);

        int second = Integer.parseInt(br.readLine());
        time = time.plusSeconds(second);

        System.out.println(time.getHour() + " " + time.getMinute() + " " + time.getSecond());
    }

}