import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) iter.next();
		
		for(int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			if(input[0].equals("P")) {
				iter.add(input[1].charAt(0));
			}
			else if(input[0].equals("L")) {
				if(iter.hasPrevious()) iter.previous();
			}
			else if(input[0].equals("D")) {
				if(iter.hasNext()) iter.next();
			}
			else if(input[0].equals("B")) {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character chr : list) sb.append(chr);
		
		System.out.println(sb);
	}

}
