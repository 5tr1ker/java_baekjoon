import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        String N = st.nextToken();
        String M = st.nextToken();

        if(N.equals(M)) {
            System.out.println(1);

            return;
        }
        System.out.println(0);
    }
}