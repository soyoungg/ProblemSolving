import java.util.Arrays;
import java.util.Scanner;

public class BJ11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int [N + 1];
		int dp[] = new int [N + 1];
		
		int res = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(dp[i], res);
		}
		System.out.println(res);
	}
}
