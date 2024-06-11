import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        LocalDate day = LocalDate.of(2015,M,D);
        if(day.compareTo(LocalDate.of(2015,2,18)) > 0) {
            System.out.println("After");
        } else if(day.compareTo(LocalDate.of(2015,2,18)) < 0) {
            System.out.println("Before");
        } else {
            System.out.println("Special");
        }

    }

}