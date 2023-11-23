import java.math.BigInteger;
import java.util.*;
import java.io.*;


class Main {

    static boolean check[];
    static int ans[] , N;
    static boolean [][]maps;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        if(L % 5 == 0) {
            System.out.println(L / 5);
        } else {
            System.out.println(L / 5 + 1);
        }

    }

}