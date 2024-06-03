import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            double arr[] = new double[N];
            for(int j =0 ; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if(N % 2 == 0) {
                System.out.printf("Case %d: %.1f\n" , i ,(arr[N / 2 - 1] + arr[N / 2]) / 2.0);
            } else {
                System.out.printf("Case %d: %.1f\n" , i , arr[N / 2]);
            }
        }

    }

}