import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2225_합분해 {
	static int dp[][];
	static int N, K, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int [201][201];
		
		for (int i = 0; i < 201; i++) {
			dp[1][i] = i;
			dp[i][1] = 1;
		}
		
		for (int i = 2; i < 201; i++ ) {
			for (int j = 2; j < 201; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
