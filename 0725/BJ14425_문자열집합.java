import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14425_문자열집합 {
	static String[] origin, test;
	static int N, M, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		origin = new String[N];
		test = new String[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			origin[i] = st.nextToken();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			test[i] = st.nextToken();
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(test[i].equals(origin[j])) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
