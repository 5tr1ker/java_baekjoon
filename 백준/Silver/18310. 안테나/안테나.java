import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			al.add(sc.nextInt());
		}
		
		Collections.sort(al);
		
		int median = (n-1) / 2;
		
		System.out.println(al.get(median));
		

	}

}