import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		if(checkPpap()) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
	
	public static boolean checkPpap() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ppap = br.readLine();
		int strLength = ppap.length();
		boolean returnData = false;
		int pCount = 0;
		
		if(ppap.charAt(strLength - 1) == 'P') {
			returnData = true;
			
			for(int i = 0; i < strLength; i++) {
				char charIdx = ppap.charAt(i);
				if(charIdx == 'P') { // P 일 때
					pCount++;
				} else if(charIdx == 'A') { // A 일 때
					if(ppap.charAt(i + 1) != 'P' || pCount < 2) { // P 갯수가 모자르다.
						returnData = false;
						break;
					}
					pCount -= 2;
				}
			}
			
			if(pCount != 1) {
				returnData = false;
			}
		}
		
		
		return returnData;
	}
	
}