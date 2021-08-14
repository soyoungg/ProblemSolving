import java.util.Scanner;

public class BJ10870_피보나치수5 {
	static int dp[];
	static int N, res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dp = new int [10001];
		
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[N]);
	}
}
