import java.lang.*;

class Solution {
    
    static String[][] map = new String[3][3];
    
    public int solution(String[] board) {
        int countO = 0 , countX = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = board[i].substring(j , j + 1);
                if(map[i][j].equals("O")) {
                    countO++;
                } else if (map[i][j].equals("X")) {
                    countX++;
                }
            }
        }
        
        if(countO < countX || Math.abs(countO - countX) > 1) {
            System.out.println("숫자가 안맞아.");
            return 0;
        }
        
        int scoreX = 0;
        int scoreO = 0;
        for(int i = 0; i < 3; i++) {
            // 가로
            if(map[i][0].equals("X") && map[i][1].equals("X") && map[i][2].equals("X")) {
                scoreX++;
            } else if(map[i][0].equals("O") && map[i][1].equals("O") && map[i][2].equals("O")) {
                scoreO++;
            }
            
            // 세로
            if(map[0][i].equals("X") && map[1][i].equals("X") && map[2][i].equals("X")) {
                scoreX++;
            } else if (map[0][i].equals("O") && map[1][i].equals("O") && map[2][i].equals("O")) {
                scoreO++;
            }
        }
        
        // sason
        if(map[0][0].equals("X") && map[1][1].equals("X") && map[2][2].equals("X")) {
            scoreX++;
        } else if (map[0][0].equals("O") && map[1][1].equals("O") && map[2][2].equals("O")) {
            scoreO++;
        }
        
        if(map[0][2].equals("X") && map[1][1].equals("X") && map[2][0].equals("X")) {
            scoreX++;
        } else if (map[0][2].equals("O") && map[1][1].equals("O") && map[2][0].equals("O")) {
            scoreO++;
        }
        
        System.out.println(scoreO + "//" + scoreX);
        
        if(scoreO > 0 && scoreX > 0) return 0;
        if(scoreO > 0 && countX >= countO) return 0;
        if(scoreX > 0 && countX < countO) return 0;
        
        return 1;
    }
}