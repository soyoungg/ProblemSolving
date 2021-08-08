import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2565_전깃줄 {
	static int N, res;
	static int dp[];
	static class Data implements Comparable<Data>{
		int left;
		int right;
		public Data(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public int compareTo(Data o) {
			return this.left - o.left;
		}	
	}
	static Data arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new Data[N];
		dp = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			arr[i] = new Data(l, r);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j > -1; j--) {
				if(arr[i].right > arr[j].right) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		System.out.println(N - res);
	}
}
