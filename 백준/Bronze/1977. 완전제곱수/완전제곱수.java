import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int M = Integer.parseInt(br.readLine());
       int N = Integer.parseInt(br.readLine());

       int first = 0;
       int second = 0;
       for(int i = 1 ; ; i++) {
           if(i * i >= M) {
               first = i * i;

               while(i * i <= N) {
                   second += i * i;

                   i++;
               }

               break;
           }
       }

       if(second == 0) {
           System.out.println(-1);
       } else {
           System.out.println(second + "\n" + first);
       }
    }
}