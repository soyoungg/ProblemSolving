import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048_이동하기 {
	static int N, M, mx;
	static int map[][];
	static int candy[][];
	static int dr[] = {-1, 0, -1};
	static int dc[] = {0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		candy = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mx = 0;
				for (int dir = 0; dir < 3; dir++) {
					int nR = i + dr[dir];
					int nC = j + dc[dir];
					
					if(nR < 0 || nC < 0 || nR >= N || nC >= M)
						continue;
					
					mx = Math.max(mx,  candy[nR][nC]);
				}
				candy[i][j] = mx + map[i][j];
			}
		}
		
		System.out.println(candy[N - 1][M - 1]);
	}
}
