import java.util.Scanner;

/*
 * 왜, 다시 ( 0,0 ) 에서 시작 안해도 될까?
 * 
 * ex. (0,0) 수정 -> ( 0,2 ) 수정 -> ( 0,1 ) 수정 
 */

public class Main {
	static int[][] matA;
	static int[][] matB;
	static int N , M;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		matA = new int [N][M];
		matB = new int [N][M];
		
		
		// matA input
		for ( int i=0; i<N; i++) {
			String str = sc.next();
			for ( int j=0; j<M; j++) {
				matA[i][j] = str.charAt(j);
			}
		}
		
		// matB input
		for ( int i=0; i<N; i++) {
			String str = sc.next();
			for ( int j=0; j<M; j++) {
				matB[i][j] = str.charAt(j);
			}
		}
		
		// 뭐 바꿀 수 있는게 없잖아.
		if ( N < 3 || M < 3) {
			if ( IsSame(matA,matB) ) {
				answer = 0;
			}
			else {
				answer = -1;
			}
		}
		// 바꿔보자
		else {
			Solution();
		}
		
		if( !IsSame(matA, matB)) {
			answer = -1;
		}
		
		System.out.println(answer);
	}

	private static void Solution() {
		// TODO Auto-generated method stub
		// 3*3 만 바꿀 수 있으니, ( N-2, M-2 ) 까지밖에 못감
		for( int i=0; i<N-2 ; i++) {
			for ( int j=0; j<M-2 ;j ++) {
				if ( matA[i][j] != matB[i][j]) {
					filp(i,j);
					answer ++;
				}
			}
		}
	}

	private static void filp(int cr, int cn) {
		// TODO Auto-generated method stub
		
		for ( int i=cr; i< cr+3; i++) {
			for ( int j=cn; j<cn+3; j++) {
				matA[i][j] = matA[i][j] ^ 1 ; // 뒤집기
			}
		}
		
	}

	private static boolean IsSame(int[][] matA2, int[][] matB2) {
		// TODO Auto-generated method stub
		for ( int i=0; i<N; i++) {
			for ( int j=0; j<M;j ++){
				if ( matA2[i][j] != matB2[i][j] ) return false; 
			}
		}
		
		return true;
	}
}
