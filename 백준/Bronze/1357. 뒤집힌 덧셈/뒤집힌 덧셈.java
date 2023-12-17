import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rexX = 0;
        String xToken = st.nextToken();
        for(int i = 0; i < xToken.length(); i++) {
            int index = Integer.parseInt(xToken.substring(i , i + 1));
            rexX += Math.pow(10 , i) * index;
        }

        int rexY = 0;
        String yToken = st.nextToken();
        for(int i = 0; i < yToken.length(); i++) {
            int index = Integer.parseInt(yToken.substring(i , i + 1));
            rexY += Math.pow(10 , i) * index;
        }

        String result = Integer.toString(rexX + rexY);
        StringBuilder sb = new StringBuilder(result).reverse();
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
