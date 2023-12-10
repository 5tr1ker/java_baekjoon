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
            int disk = Integer.parseInt(st.nextToken());

            if(disk != 0) {
                sum += (disk / size);
                if(disk % size != 0) {
                    sum++;
                }
            }
        }

        System.out.println(size * sum);
    }

}