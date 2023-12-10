import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long size = Integer.parseInt(br.readLine());

        long sum = 0;
        for(int i = 0; i < N; i++) {
            double disk = Double.parseDouble(st.nextToken());

            sum += Math.ceil(disk / size);
        }

        System.out.println(size * sum);
    }

}