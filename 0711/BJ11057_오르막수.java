import java.util.Scanner;

public class BJ11057_오르막수 {
	static int dp[][];
	static int N, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int [N + 1][11];
		for (int i = 0; i < 10; i++) 
			dp[1][i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++ ) {
					dp[i][j] += dp[i - 1][k];
				}
				dp[i][j] %= 10007;
			}
		}
		
		for (int i = 0; i <= 10; i++) {
			res += dp[N][i];
		}
		res %= 10007;
		System.out.println(res);
	}
}
