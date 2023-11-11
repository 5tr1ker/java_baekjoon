import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = br.readLine().length();
        int b = br.readLine().length();

        if(a < b) {
            System.out.println("no");

            return;
        }

        System.out.println("go");

    }
}