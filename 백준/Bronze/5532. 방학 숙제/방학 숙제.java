import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        double A = Double.parseDouble(br.readLine());
        double B = Double.parseDouble(br.readLine());
        double C = Double.parseDouble(br.readLine());
        double D = Double.parseDouble(br.readLine());

        int a1 = (int) Math.ceil(A / C);
        int a2 = (int) Math.ceil(B / D);

        System.out.println(L - Math.max(a1 , a2));
    }

}