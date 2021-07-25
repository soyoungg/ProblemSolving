import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2293_동전1 {
	static int res[], coin[];
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		res = new int [K + 1];
		coin = new int [N + 1];
		res[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				res[j] += res[j - coin[i]];
			}
		}
		System.out.println(res[K]);
	}
}
