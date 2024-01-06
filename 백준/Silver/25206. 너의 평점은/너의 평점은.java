import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static double changeScore(String score) {
        switch (score){
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            default:
                return 1.0;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalScore = 0.0;
        double sumScore = 0.0;

        for(int i = 0; i < 20; i++) {
            String input[] = br.readLine().split(" ");
            if(input[2].equals("P")) {
                continue;
            }

            totalScore += Double.parseDouble(input[1]);
            if(input[2].equals("F")) {
                continue;
            }

            sumScore += Double.parseDouble(input[1]) * changeScore(input[2]);
        }

        System.out.printf("%f" , sumScore / totalScore);

    }

}