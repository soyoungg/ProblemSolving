import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055_가장큰증가부분수열 {
	static int arr[];
	static int res[];
	static int N, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int [N + 1];
		res = new int [N + 1];
		
		st =  new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res[1] = arr[1];
		
		for (int i = 2; i <= N; i++) {
			res[i] = arr[i];
			for (int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) {
					res[i] = Math.max(res[j] + arr[i], res[i]);
				}
			}
			if(dp < res[i]) {
				dp = res[i];
			}
		}
		
		if(dp < res[1])
			dp = res[1];
		
		System.out.println(dp);
	}
}
