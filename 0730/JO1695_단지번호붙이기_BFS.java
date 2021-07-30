import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1695_단지번호붙이기_BFS {
	static int N;
	static boolean visited[][];
	static int map[][];
	static int aptNum, aptCnt;
	static ArrayList<Integer> list;
	static Queue<Data> q;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visited = new boolean [N][N];
		list = new ArrayList<>();
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					aptNum++;
					q.add(new Data(i, j));
					bfs();
					list.add(aptCnt);
					aptCnt = 0;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(aptNum);
		for (int n : list) 
			System.out.println(n);
		
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Data cur = q.poll();
			aptCnt++;
			
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				
				if(visited[nx][ny] || map[nx][ny] == 0) 
					continue;
				
				visited[nx][ny] = true;
				q.add(new Data(nx, ny));
			}
		}
	}
}
