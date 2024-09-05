import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int z = 1; z <= N; z++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i = 0; i < b; i++) {
                for(int j = 0; j < a; j++) {
                    System.out.printf("X");
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
    }

}