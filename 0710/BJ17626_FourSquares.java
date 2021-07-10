import java.util.Scanner;

public class BJ17626_FourSquares {
	static int num[];
	static int mn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int [N + 1];
		num[1] = 1;
		for (int i = 2; i <= N; i++) {
			mn = 2147000000;
			for (int j = 1; j * j <= i; j++) {
				int tmp = i - j * j;
				mn = Math.min(mn, num[tmp]);
			}
			num[i] = mn + 1;
		}
		System.out.println(num[N]);
	}
}
