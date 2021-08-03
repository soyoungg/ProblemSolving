import java.util.Scanner;

public class BJ1309_동물원 {
	static int arr[][];
	static int res, N;
	static final int div = 9901;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[100001][3];
		arr[1][0] = arr[1][1] = arr[1][2] = 1;
		
		for (int i = 2; i < 100001; i++) {
			arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i- 1][2]) % div;
			arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % div;
			arr[i][2] = (arr[i - 1][1] + arr[i - 1][0]) % div;
		}
		res = (arr[N][0] + arr[N][1] + arr[N][2]) % div;
		System.out.println(res);
	}
}
