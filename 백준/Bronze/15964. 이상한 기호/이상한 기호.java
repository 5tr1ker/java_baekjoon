import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println((A - B) * (A + B));
    }
}