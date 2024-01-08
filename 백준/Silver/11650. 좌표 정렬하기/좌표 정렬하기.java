import java.io.*;
import java.util.*;
import java.lang.*;

class Node implements Comparable<Node> {
    int x , y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node n1) {
        if(n1.x == this.x) {
            return this.y - n1.y;
        }

        return this.x - n1.x;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Node[] arr = new Node[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Node(x , y);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

}