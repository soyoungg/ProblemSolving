import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502_연구소_BFS {
	static int N, M, cnt, res;
	static class Data {
		int r;
		int c;

		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Data> q;
	static int map[][];
	static int copyMap[][];

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기

		map = new int[N][M];
		copyMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		buildWall(0);
		System.out.println(res);
	}

	static void buildWall(int cnt) {
		if (cnt == 3) {
			spreadVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 빈 칸이라면
					map[i][j] = 1; // 벽 세우기
					buildWall(cnt + 1); //
					map[i][j] = 0; // 다시 빈 칸으로 돌려놓기
				}
			}
		}
	}

	static void spreadVirus() {
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 2) {
					q.add(new Data(i, j));
				}
			}
		}
		
		Data cur = null;
		while (!q.isEmpty()) {
			cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					q.add(new Data(nr, nc));
				}
			}
		}
		countSafePlaces();
	}


	static void countSafePlaces() {
		int safeCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					safeCnt++;
				}
			}
		}
		res = Math.max(res, safeCnt);
	}
}