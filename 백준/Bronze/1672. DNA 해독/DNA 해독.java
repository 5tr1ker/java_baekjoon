import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();

        for(int i = N - 1; i > 0; i--) {
            if(ch[i] == 'A') {
                if(ch[i - 1] == 'A') {
                    ch[i - 1] = 'A';
                }
                else if(ch[i - 1] == 'G') {
                    ch[i - 1] = 'C';
                }
                else if(ch[i - 1] == 'C') {
                    ch[i - 1] = 'A';
                }
                else if(ch[i - 1] == 'T') {
                    ch[i - 1] = 'G';
                }
            }
            else if (ch[i] == 'G') {
                if(ch[i - 1] == 'A') {
                    ch[i - 1] = 'C';
                }
                else if(ch[i - 1] == 'G') {
                    ch[i - 1] = 'G';
                }
                else if(ch[i - 1] == 'C') {
                    ch[i - 1] = 'T';
                }
                else if(ch[i - 1] == 'T') {
                    ch[i - 1] = 'A';
                }
            }
            else if (ch[i] == 'C') {
                if(ch[i - 1] == 'A') {
                    ch[i - 1] = 'A';
                }
                else if(ch[i - 1] == 'G') {
                    ch[i - 1] = 'T';
                }
                else if(ch[i - 1] == 'C') {
                    ch[i - 1] = 'C';
                }
                else if(ch[i - 1] == 'T') {
                    ch[i - 1] = 'G';
                }
            }
            else if (ch[i] == 'T') {
                if(ch[i - 1] == 'A') {
                    ch[i - 1] = 'G';
                }
                else if(ch[i - 1] == 'G') {
                    ch[i - 1] = 'A';
                }
                else if(ch[i - 1] == 'C') {
                    ch[i - 1] = 'G';
                }
                else if(ch[i - 1] == 'T') {
                    ch[i - 1] = 'T';
                }
            }
        }

        System.out.println(ch[0]);
    }

}