import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        String A = st.nextToken() + st.nextToken();
        String B = st.nextToken() + st.nextToken();

        System.out.println(Long.parseLong(A) + Long.parseLong(B));
    }

}