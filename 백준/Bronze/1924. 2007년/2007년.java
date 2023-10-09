import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String [] days = new String[]{"MON" , "TUE" , "WED" , "THU" , "FRI" , "SAT" , "SUN"};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken()) - 1;
        int targetDay = 0;

        switch(month) {
            case 5 :
                targetDay = 1;
                break;
            case 2:
            case 3:
            case 11:
                targetDay = 3;
                break;
            case 8:
                targetDay = 2;
                break;
            case 6:
                targetDay = 4;
                break;
            case 9:
            case 12:
                targetDay = 5;
                break;
            case 4:
            case 7:
                targetDay = 6;
                break;
        }

        System.out.println(days[(targetDay + day) % 7]);
    }
}