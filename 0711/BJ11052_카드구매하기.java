import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052_카드구매하기 {
	static int costs[];
	static int mx[];
	static int N;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		costs = new int [N + 1];
		mx = new int [N + 1];
		
		for (int i = 1; i <= N ; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 바로 전거에  + 1개 더하는 금액이 더 큰지
		// 지금 금액이 더 큰ㅈㅣ
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				mx[i] = Math.max(mx[i - j] + costs[j] , mx[i]);
			}
		}
		System.out.println(mx[N]);
	}
}
