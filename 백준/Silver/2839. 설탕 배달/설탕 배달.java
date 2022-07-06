import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int data = sc.nextInt();
		int amount = 0;
		
		while(data > 0) {
			if(data % 5 == 0) {
				data -= 5;
				amount++;
			} else if (data % 3 == 0) {
				data -= 3;
				amount++;
			} else if (data > 5) {
				data -= 5;
				amount++;
			}
			else {
				amount = -1;
				break;
			}
		}
		
		System.out.println(amount);
		sc.close();
	}

}