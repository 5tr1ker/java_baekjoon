import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        double BMI = weight / (height * height);
        if(BMI > 25) {
            System.out.println("Overweight");

            return;
        }

        if(BMI >= 18.5) {
            System.out.println("Normal weight");

            return;
        }

        System.out.println("Underweight");

    }

}