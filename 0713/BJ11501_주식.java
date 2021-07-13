import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11501_주식 {
	static int price[];
	static int  mx, N;
	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			price = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			mx = -1;
			res = 0;
			for (int i = N - 1; i > -1; i--) {
				if(price[i] > mx) {
					mx = price[i];
				}else {
					res += mx - price[i]; 
				}
			}
			System.out.println(res);
		}
	}
}
