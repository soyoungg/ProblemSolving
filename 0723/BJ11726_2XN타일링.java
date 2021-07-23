import java.util.Scanner;

public class BJ11726_2XN타일링 {
	static int res[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		res = new int [1001];
		res[1] = 1;
		res[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			res[i] = res[i - 1] + res[i - 2];
			res[i] %= 10007;
		}
		System.out.println(res[N]);
	}
}
