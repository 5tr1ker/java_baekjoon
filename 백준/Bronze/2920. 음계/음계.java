import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        String assentArr[] = str.clone();
        Arrays.sort(assentArr);

        String decentArr[] = str.clone();
        Arrays.sort(decentArr , Collections.reverseOrder());

        if(Arrays.equals(str , assentArr)) {
            System.out.println("ascending");
        } else if(Arrays.equals(str , decentArr)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}