import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2468_안전영역_DFS {
	static int map[][];
	static boolean visited[][];
	static int N, res, mn, mx, cnt;
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visited = new boolean [N][N];
		mn = 2147000000;
		mx = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mn = Math.min(mn, map[i][j]);
				mx = Math.max(mx, map[i][j]);
			}
		}
		
		for (int height = mn; height <= mx; height++) {
			visited = new boolean [N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > height ) {
						cnt++;
						visited[i][j]= true;
						dfs(i, j, height);
					}
				}
			}
			
			res = Math.max(cnt, res);
		}
		
		System.out.println(res == 0 ? 1 : res);
	}
	
	static void dfs(int r, int c, int h) {
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			
			if(visited[nr][nc] || map[nr][nc] <= h)
				continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, h);
		}
	}
}
