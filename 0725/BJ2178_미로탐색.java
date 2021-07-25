import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로탐색 {
	static int map[][];
	static boolean visited[][];
	static int N, M, res, count;
	static class Data{
		int x;
		int y;
		int cnt;
		public Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static Queue<Data> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		res = bfs();
		System.out.println(res);
		
	}
	
	static int bfs() {
		visited[0][0] = true;
		q.add(new Data(0, 0, 1));
		
		Data cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.x == N - 1 && cur.y == M - 1) {
				count = cur.cnt;
				break;
			}
				
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				int nCnt = cur.cnt + 1;
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				q.add(new Data(nr, nc, nCnt));
			}
		}
		
		return count;
	}
}
