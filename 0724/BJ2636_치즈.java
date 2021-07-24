import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636_치즈 {
	static int N, M, time, originCheeseCnt, res;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean visited[][];
	static int map[][];
	static Queue<Data> q;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					originCheeseCnt++;
			}
		}
		
	
		
		while(originCheeseCnt != 0) {
			time++;
			res = originCheeseCnt;
			searchMap(0, 0);
		}
		System.out.println(time);
		System.out.println(res);
	}
	
	public static void searchMap(int cr, int cc) {
		visited = new boolean [N][M];
		q = new LinkedList<>();
		visited[cr][cc] = true;
		q.add(new Data(cr, cc));
		
		Data cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nR = cur.x + dr[dir];
				int nC = cur.y + dc[dir];
				
				if(nR < 0 || nC < 0 || nR >= N || nC >= M)
					continue;
				
				if(visited[nR][nC])
					continue;
					
				if(map[nR][nC] == 1) {
					map[nR][nC] = 0;
					originCheeseCnt--;
				}

				else if(map[nR][nC] == 0) {
					q.add(new Data(nR, nC));
				}
				visited[nR][nC] = true;
			}
		}
		
		
	}
	
}
