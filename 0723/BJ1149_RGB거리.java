import java.util.Scanner;

public class BJ1149_RGB거리 {
	static int rgb[][];
	static int res[][];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rgb = new int [N][3];
		res = new int [N][3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = sc.nextInt();
			}
		}
		
		res[0][0] = rgb[0][0];
		res[0][1] = rgb[0][1];
		res[0][2] = rgb[0][2];
		
		for (int i = 1; i < N; i++) {
			res[i][0] = Math.min(res[i-1][1], res[i-1][2]) + rgb[i][0];
			res[i][1] = Math.min(res[i-1][0], res[i-1][2]) + rgb[i][1];
			res[i][2] = Math.min(res[i-1][0], res[i-1][1]) + rgb[i][2];
		}
		System.out.println(Math.min(res[N - 1][0], Math.min(res[N - 1][1], res[N - 1][2])));
	}
}
