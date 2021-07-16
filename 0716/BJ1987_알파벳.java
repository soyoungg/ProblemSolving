import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {
	static int map[][];
	static boolean alpha[], visited[][];
	static int R, C;
	static int res;
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		alpha = new boolean [26];
		visited = new boolean [R][C];
		res = -1;
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c) - 65;
			}
		}
		
		visited[0][0] = true;
		alpha[map[0][0]] = true;
		go(0, 0, alpha, visited, 1);
		System.out.println(res);
	}
	
	static void go(int cr, int cc, boolean alpha[], boolean visited[][], int cnt) {
		for (int dir = 0; dir < 4; dir++) {
			if(cnt > res)
				res = cnt;
			
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			
			if(visited[nr][nc])
				continue;
			
			if(alpha[map[nr][nc]])
				continue;
			
			alpha[map[nr][nc]] = true;
			visited[nr][nc] = true;
			
			go(nr, nc, alpha, visited, cnt + 1);
			
			alpha[map[nr][nc]] = false;
			visited[nr][nc] = false;
		}
	}
}
