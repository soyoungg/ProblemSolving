import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606_유기농배추_BFS {
	static int map[][];
	static boolean visited[][];
	static int T, M, N, K, res;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static Queue<Data> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 가로
			M = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken());
			res = 0;
			q = new LinkedList<>();
			map = new int [N][M];
			visited = new boolean [N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						res++;
						visited[i][j] = true;
						q.add(new Data(i, j));
						go();
					}
				}
			}
			System.out.println(res);
		}
	}
	
	static void go() {
		while(!q.isEmpty()) {
			Data cur = null;
			cur = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M )
					continue;
				
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				q.add(new Data(nr, nc));
			}
		}
	}
}
