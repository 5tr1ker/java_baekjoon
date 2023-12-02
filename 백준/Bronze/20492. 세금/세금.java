import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        System.out.println((int)(a - a * 0.22) + " " + (int)(a - a * 0.2 * 0.22));
    }
}