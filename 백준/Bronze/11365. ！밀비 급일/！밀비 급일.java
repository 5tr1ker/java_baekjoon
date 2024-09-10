import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();

            if(input.equals("END")) {
                return;
            }

            System.out.println(new StringBuilder(input).reverse());
        }
    }

}