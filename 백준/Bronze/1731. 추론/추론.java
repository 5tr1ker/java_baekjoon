import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(arr[2] - arr[1] == arr[1] - arr[0]) {
            System.out.println(arr[N - 1] + arr[1] - arr[0]);

            return;
        }

        long temp = arr[1] / arr[0];
        System.out.println(arr[N - 1] * temp);
    }
}