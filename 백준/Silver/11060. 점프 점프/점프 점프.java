import java.util.*;
import java.io.*;


class Node {
    int index;
    int time;

    public Node(int index , int time) {
        this.index = index;
        this.time = time;
    }
}

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0 , 0));
        boolean check[] = new boolean[N];
        check[0] = true;

        while(!queue.isEmpty()) {
            Node next = queue.poll();

            if(next.index >= N - 1) {
                System.out.println(next.time);
                return;
            }

            for(int i = 1; i <= arr[next.index]; i++) {
                if(next.index + i < N && !check[next.index + i]) {
                    check[next.index + i] = true;
                    queue.offer(new Node(next.index + i , next.time + 1));
                }
            }
        }

        System.out.println(-1);

    }
}