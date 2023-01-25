import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str1[] = br.readLine().split("");
		String str2[] = br.readLine().split("");
		
		int arr1[] = new int[N]; // 첫번째를 키고 시작할 때
		int arr2[] = new int[N]; // 그냥 시작할 때
		int dest[] = new int[N];
		int idx1 = 1;
		int idx2 = 0;
		
		for(int i = 0; i < N; i++) {
			arr1[i] = arr2[i] = Integer.parseInt(str1[i]);
			dest[i] = Integer.parseInt(str2[i]);
		}
		
		arr1[0] = arr1[0] == 0 ? 1 : 0;
		arr1[1] = arr1[1] == 0 ? 1 : 0;
		
		for(int i = 0; i < N - 1; i++) {
			if(arr1[i] != dest[i]) {
				arr1 = switching(arr1 , i);
				idx1++;
			}
			if(arr2[i] != dest[i]) {
				arr2 = switching(arr2 , i);
				idx2++;
			}
		}
		
		int result = 100_000_000;
		if(checking(arr1 , dest , N)) result = Math.min(result , idx1);
		if(checking(arr2 , dest , N)) result = Math.min(result , idx2);
		
		if(result == 100_000_000) System.out.println(-1);
		else System.out.println(result);
		
	}
	
	public static int[] switching(int arr[] , int idx) {
		for(int i = 0; i < 3; i++) {
			if(idx + i >= arr.length) break;
			arr[idx + i] = arr[idx + i] == 0 ? 1 : 0;
		}
		
		return arr;
	}
	
	public static boolean checking(int arr[] , int dest[] , int N) {
		for(int i = 0; i < N; i++)
			if(arr[i] != dest[i]) return false;
		
		return true;
	}
	
}