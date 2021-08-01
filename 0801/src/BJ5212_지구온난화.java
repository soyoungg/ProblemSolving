import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ5212_지구온난화 {
	static char map[][];
	static int cnt[][];
	static ArrayList<Character> list[];
	static int R, C, sr, sc, er, ec;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R + 2][C + 2];
		cnt = new int [R + 2][C + 2];
		
		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				map[i][j] = '.';
			}
		}
	
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		
		iceberg();
		check();
		
		for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void iceberg() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] == 'X') {
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						
						if(map[nr][nc] == '.') {
							cnt[i][j]++;
						}
					}
					
				}
			}
		}
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(cnt[i][j] > 2) {
					map[i][j] = '.';
				}
			}
		}
	}
	
	// 중복되는 함수 줄여보자
	public static void check() {
		boolean flag = false;
		for (int i = 1; i <= R; i++) { // 시작 행 찾기
			if(!flag) {
				for (int j = 1; j <= C; j++) {
					if(map[i][j] == 'X') {
						sr = i;
						flag = true;
						break;
					}
				}
			}else 
				break;
		}
		
		flag = false;
		for (int i = R; i > 0; i--) {
			if(!flag) {
				for (int j = C; j > 0; j--) {
					if(map[i][j] == 'X') {
						er = i; 
						flag = true;
						break;
					}
				}
				
			}else {
				break;
			}
		}
		
		flag = false;
		for (int i = 1; i <= C; i++) {
			if(!flag) {
				for (int j = 1; j <= R; j++) {
					if(map[j][i] == 'X') {
						sc = i; 
						flag = true;
						break;
					}
				}
			}else {
				break;
			}
		}
		
		flag = false;
		for (int i = C; i > 0; i--) {
			if(!flag) {
				for (int j = R; j > 0; j--) {
					if(map[j][i] == 'X') {
						ec = i; 
						flag = true;
						break;
					}
				}
			}else {
				break;
			}
		}
	}
}
