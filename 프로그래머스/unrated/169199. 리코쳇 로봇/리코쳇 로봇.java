import java.lang.*;
import java.util.*;

class Node {
    int x;
    int y;
    int count;
    
    public Node(int x , int y , int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    
    static String maps[][];
    static boolean checks[][];
    static int coorX[] = {-1,1,0,0};
    static int coorY[] = {0,0,-1,1};
    static int x;
    static int y;
    
    public int goLeft(int x , int y) {
        while(true) {
            int dy = y - 1;
            
            if(dy < 0 || maps[x][dy].equals("D")) {
                return y;
            }
            
            y = dy;
        }
    }
    
    public int goRight(int x , int y) {
        while(true) {
            int dy = y + 1;
            
            if(dy >= this.y || maps[x][dy].equals("D")) {
                return y;
            }
            
            y = dy;
        }
    }
    
    public int goUp(int x , int y) {
        while(true) {
            int dx = x - 1;
            
            if(dx < 0 || maps[dx][y].equals("D")) {
                return x;
            }
            
            x = dx;
        }
    }
    
    public int goDown(int x , int y) {
        while(true) {
            int dx = x + 1;
            
            if(dx >= this.x || maps[dx][y].equals("D")) {
                return x;
            }
            
            x = dx;
        }
    }
    
    public int solution(String[] board) {
        x = board.length;
        y = board[0].length();
        maps = new String[x][y];
        checks = new boolean[x][y];
        Queue<Node> queue = new LinkedList<>();
        
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                maps[i][j] = board[i].substring(j , j + 1);
                
                if(maps[i][j].equals("R")) {
                    queue.offer(new Node(i , j , 0));
                    checks[i][j] = true;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int resultX = node.x , resultY = node.y;
            if(maps[resultX][resultY].equals("G")) {
                return node.count;
            }
            
            // goLeft
            resultY = goLeft(node.x , node.y);
            if(!checks[node.x][resultY]) {
                checks[node.x][resultY] = true;
                queue.offer(new Node(node.x , resultY , node.count + 1));
            }
            
            // goRight
            resultY = goRight(node.x , node.y);
            if(!checks[node.x][resultY]) {
                checks[node.x][resultY] = true;
                queue.offer(new Node(node.x , resultY , node.count + 1));
            }
            
            // goDown
            resultX = goDown(node.x , node.y);
            if(!checks[resultX][node.y]) {
                checks[resultX][node.y] = true;
                queue.offer(new Node(resultX , node.y , node.count + 1));
            }
            
            // goUp
            resultX = goUp(node.x , node.y);
            if(!checks[resultX][node.y]) {
                checks[resultX][node.y] = true;
                queue.offer(new Node(resultX , node.y , node.count + 1));
            }
        }
        
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                    System.out.printf("%s " , checks[i][j] ? "T" : "F");
                }
            System.out.println();
        }
        
        return -1;
    }
}