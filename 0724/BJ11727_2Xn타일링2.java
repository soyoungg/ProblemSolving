import java.util.Scanner;

public class BJ11727_2Xn타일링2 {
	static int N;
	static int res[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		res = new int [1001];
		res[1] = 1;
		res[2] = 3;
		res[3] = 5;
		
		for (int i = 4; i <= N; i++) {
			res[i]= res[i - 1] + (res[i - 2] * 2) ;
			res[i] %= 10007;
		}
		System.out.println(res[N]);
	}
}
