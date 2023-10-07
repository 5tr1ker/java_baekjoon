import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        int d3 = Integer.parseInt(br.readLine());

        if(d1 + d2 + d3 != 180) {
            System.out.println("Error");
        } else if(d1 != d2 && d1 != d3 && d2 != d3) { // 모두 다름
            System.out.println("Scalene");
        } else if(d1 == 60 && d2 == 60 && d3 == 60) { // 모두 60
            System.out.println("Equilateral");
        } else {
            System.out.println("Isosceles"); // 2개만
        }
    }
}