import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051_숫자정사각형 {
	static int N, M;
	static int map[][];
	static int res, mx, tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mx = Math.min(N, M);
		map = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		res = 1;
		
		for(int width = 1; width < mx; width++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					isAvailable(i, j, width);
				}
			}
		}
		System.out.println(res);
	}
	
	public static void isAvailable(int r, int c, int k) {
		if(r + k >= N || c + k >= M)
			return;
		
		if(map[r][c] == map[r + k][c] && map[r][c] == map[r + k][c + k]
				&& map[r][c] == map[r][c + k]) {
			k++;
			tmp = k * k;
			res = Math.max(tmp, res);
		}
		else 
			return;
	}
}
