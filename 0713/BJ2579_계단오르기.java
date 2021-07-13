import java.util.Scanner;

public class BJ2579_계단오르기 {
	static int stair[], score[][];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stair = new int [301];
		score = new int [301][2];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		score[1][0] = score[1][1] = stair[1];
		score[2][0] = score[1][0] + stair[2];
		score[2][1] = stair[2];
		for (int i = 3; i <= N; i++) {
			score[i][0] = score[i - 1][1] + stair[i];
			score[i][1] = Math.max(score[i - 2][0], score[i - 2][1]) + stair[i];
		}
		System.out.println(Math.max(score[N][0], score[N][1]));
	}
}
