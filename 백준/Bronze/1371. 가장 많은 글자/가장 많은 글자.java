import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[26];


        try {
            while(true) {
                String str = br.readLine();

                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ' ') {
                        continue;
                    }
                    arr[str.charAt(i) - 'a'] += 1;
                }
            }

        } catch (Exception e) {
            int max = -1;
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                if(max < arr[i]) {
                    max = arr[i];

                    sb = new StringBuilder();
                    sb.appendCodePoint('a' + i);
                }
                else if(max == arr[i]) {
                    sb.appendCodePoint('a' + i);
                }
            }

            System.out.println(sb);
        }

    }
}
