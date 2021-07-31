import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589_보물섬 {
	static int map[][];
	static boolean visited[][];
	static int N, M, res;
	static Queue<Data> q;

	static class Data {
		int r;
		int c;
		int cnt;

		public Data(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if(c == 'W') { // 바다라면 map에 0으로 들어감
					map[i][j] = 0;
				}else { // 육지라면 map에 1로 들어감
					map[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				if(map[i][j] == 1 && !visited[i][j]) {
					findTreasure(i, j);
				}
			}
		}
		
		System.out.println(res);
	}
	
	public static  void findTreasure(int cR, int cC) {
		q = new LinkedList<>();
		visited[cR][cC] = true;
		q.add(new Data(cR, cC, 0));
		
		Data cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur.cnt > res) {
				res = cur.cnt;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int nR = cur.r + dr[dir];
				int nC = cur.c + dc[dir];
				
				if(nR < 0 || nC < 0 || nR >= N || nC >= M)
					continue;
				
				if(visited[nR][nC] || map[nR][nC] == 0)
					continue;
				
				visited[nR][nC] = true;
				q.add(new Data(nR, nC, cur.cnt + 1));
			}
		}
	}
}
