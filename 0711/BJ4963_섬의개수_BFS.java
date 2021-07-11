import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963_섬의개수_BFS {
	static int map[][];
	static boolean visited[][];
	static Queue <Data> q;
	static int w, h, res;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dc[] = {0, 0, -1, 1, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); // 너비 j
			h = Integer.parseInt(st.nextToken()); // 높이 i
			q = new LinkedList<>();
			
			if(w == 0 && h == 0) break;
			map = new int [h][w];
			visited = new boolean [h][w];
			res = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						res++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(res);
		}
	}
	
	static void bfs(int r, int c) {
		visited[r][c] = true;
		q.add(new Data(r, c));
		
		while(!q.isEmpty()) {
			Data cur = null;
			cur = q.poll(); 
			
			for (int dir = 0; dir < 8; dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= h || nc >= w)
					continue;
				
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				q.add(new Data(nr, nc));
			}
		}
	}
}
