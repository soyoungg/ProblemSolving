import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10026_적록색약 {
	static int N, isColorBlind, notColorBlind;
	static char map[][];
	static boolean visited[][];
	static Queue<Data> q;
	static class Data{
		int x;
		int y;
		char color;
		public Data(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char [N][N];
		visited = new boolean [N][N];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 적록색약 아닌 사람이 구역 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					notColorBlind++;
					count(i, j);
				}
			}
		}
		
		visited = new boolean [N][N];
		redToGreen();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					isColorBlind++;
					count(i, j);
				}
			}
		}
		
		System.out.println(notColorBlind + " " + isColorBlind);
	}
	
	static void count(int cR, int cC) {
		visited[cR][cC] = true;
		q.add(new Data(cR, cC, map[cR][cC]));
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nR = cur.x + dr[dir];
				int nC = cur.y + dc[dir];
				
				if(nR < 0 || nC < 0 || nR >= N || nC >= N)
					continue;
				
				if(visited[nR][nC] || map[nR][nC] != cur.color)
					continue;
				
				visited[nR][nC] = true;
				q.add(new Data(nR, nC, map[nR][nC]));
			}
		}
	}
	
	static void redToGreen() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}
	}
}
