import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        int K = 1;
        while(true) {

            if(N <= 0) {
                break;
            }

            if(K > N) {
                K = 1;
            }
            N -= K;
            ans ++;

            K++;
        }
        System.out.println(ans);
    }

}