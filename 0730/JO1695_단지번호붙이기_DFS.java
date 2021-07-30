import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO1695_단지번호붙이기_DFS {
	static int map[][];
	static boolean visited[][];
	static int N, aptCnt, aptNum;
	static ArrayList<Integer>list;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visited = new boolean [N][N];
		list = new ArrayList<>();
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
					aptNum++;
					dfs(i, j);
					list.add(aptCnt);
					aptCnt = 0;
				}
			}
		}
		Collections.sort(list);

		System.out.println(aptNum);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	static void dfs(int cx, int cy) {
		visited[cx][cy] = true;
		aptCnt++;
		
		int nx = 0; int ny = 0;
		
		for (int i = 0; i < 4; i++) {
			nx = cx + dx[i];
			ny = cy + dy[i];
			
			// 범위를 벗어나면 무시
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			// 이미 방문했거나, 아파트가 없는 곳(0)이라면 무시
			if(visited[nx][ny] || map[nx][ny] == 0)
				continue;
			dfs(nx, ny);
		}
	}
}
