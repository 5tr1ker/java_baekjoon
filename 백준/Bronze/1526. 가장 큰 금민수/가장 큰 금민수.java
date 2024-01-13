import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = N; i >= 4; i--) {
            String str = Integer.toString(i);

            if(str.contains("1") || str.contains("2") ||
                    str.contains("3") || str.contains("5") ||
                    str.contains("6") || str.contains("8") ||
                    str.contains("9") || str.contains("0")) {

                continue;
            }

            System.out.println(str);

            return;
        }
    }

}