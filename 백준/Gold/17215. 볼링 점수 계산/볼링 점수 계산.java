import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scoreBoard = br.readLine().split("");
		int totalScore = 0;

		for(int i = 0 , j = 1; i < scoreBoard.length; i++ , j++) {
			if(j >= 10) {
				for( ; i < scoreBoard.length; i++) {
					if(scoreBoard[i].equals("S")) totalScore += 10;
					else if (i + 2 <= scoreBoard.length && scoreBoard[i + 1].equals("P")) {totalScore += 10; i++; }
					else if(scoreBoard[i].equals("-")) totalScore += 0;
					else totalScore += Integer.parseInt(scoreBoard[i]);
				}
			}
			else if(scoreBoard[i].equals("S")) {	// Strike
					if(scoreBoard[i + 1].equals("S")) { // Sequence Strike
						if(scoreBoard[i + 2].equals("S")) {
							totalScore += 30;
						} else {
							if(scoreBoard[i + 2].equals("-")) totalScore += 20;
							else totalScore += 20 + Integer.parseInt(scoreBoard[i + 2]);
						}
					} 
					else {
						if (scoreBoard[i + 2].equals("P")) { // Strike Spare
							totalScore += 20;
						} else { // Strike OpenFrame
							if(scoreBoard[i + 1].equals("-")) { // Strike Gutter
								if(scoreBoard[i + 2].equals("-")) totalScore += 10;
								else totalScore += 10 + Integer.parseInt(scoreBoard[i + 1]);
							} else { // Strike Pin
								if(scoreBoard[i + 2].equals("-")) totalScore += 10 + Integer.parseInt(scoreBoard[i + 1]);
								else totalScore += 10 + Integer.parseInt(scoreBoard[i + 1]) + Integer.parseInt(scoreBoard[i + 2]);
							}
						}
					}
			} 
			else {
				if(scoreBoard[i + 1].equals("P")) { // Spare
					if(scoreBoard[i + 2].equals("-")) { // Gutter
						totalScore += 10;
					} else if(scoreBoard[i + 2].equals("S")) {
						totalScore += 20;
					} else {
						totalScore += 10 + Integer.parseInt(scoreBoard[i + 2]);
					}
					i++;
				} else { // OpenFrame
					if(scoreBoard[i].equals("-")) {
						if(scoreBoard[i + 1].equals("-")) totalScore += 0;  // 2개 모두 오픈
						else totalScore += Integer.parseInt(scoreBoard[i + 1]); // 오픈 후 스페어
					}
					else {
						if(scoreBoard[i + 1].equals("-")) totalScore += Integer.parseInt(scoreBoard[i]);
						else totalScore += Integer.parseInt(scoreBoard[i]) + Integer.parseInt(scoreBoard[i + 1]);
					}
					i++;
				}
			}
		}
		System.out.println(totalScore);
	}
}