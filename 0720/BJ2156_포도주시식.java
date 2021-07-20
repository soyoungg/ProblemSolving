import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2156_포도주시식 {
	static int mx[], wine[];
	static int N, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		mx = new int [10001];
		wine = new int [10001];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			wine[i] = Integer.parseInt(st.nextToken());
		}
		
		mx[1] = wine[1];
		mx[2] = mx[1] + wine[2];
		mx[3] = Math.max(mx[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));
		for (int i = 4; i <= N; i++) {
			mx[i] = Math.max(Math.max(mx[i - 3] + wine[i - 1] + wine[i],  mx[i - 2] + wine[i]),mx[i - 1]);    
		}
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, mx[i]);
		}
		System.out.println(res);
	}
}
