import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chArr = str.toCharArray();
        int len = chArr.length;

        int nextAdd = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 1; i--) {
            int num = (int) chArr[i] - '0';
            int nowNum = num + nextAdd;
            nextAdd = nowNum >= 5 ? 1 : 0;
            sb.append(0);
        }
        sb.insert(0, (int)(chArr[0] - '0') + nextAdd);
        System.out.println(sb.toString());
    }

}