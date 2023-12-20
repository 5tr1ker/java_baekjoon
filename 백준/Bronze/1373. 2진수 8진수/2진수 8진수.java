import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bg = new BigInteger(br.readLine() , 2);

        System.out.println(bg.toString(8));
    }
}
