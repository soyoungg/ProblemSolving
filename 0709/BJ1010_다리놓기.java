import java.util.Scanner;

public class BJ1010_다리놓기 {
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		map = new int [31][31];
		
		for (int i = 0; i < 31; i++) {
			map[1][i] = i;
			map[i][1] = i;
		}
		
		for (int i = 2; i < 31; i++) {
			for (int j = 2; j < 31; j++) {
				if(i == j) {
					map[i][j] = 1;
				}
				else {
					map[i][j] = map[i - 1][j - 1] + map[i][j - 1];
				}
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			System.out.println(map[r][c]);
		}
	}
}
