import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095_123더하기 {
	static int num[];
	static int res, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num = new int [11];
			num[1] = 1;
			num[2] = 2;
			num[3] = 4;
				for (int i = 4; i <= 10; i++) {
					num[i] = num[i - 1] + num[i - 2] + num[i - 3];
				}
			System.out.println(num[N]);
		}
	}
}
