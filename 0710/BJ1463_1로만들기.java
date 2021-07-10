import java.util.Scanner;

public class BJ1463_1로만들기 {
	static int N;
	static int num[];
	static int mn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int [N + 1];
		for (int i = 2; i <= N; i++) {
			mn = 2147000000;
			if(i % 2 == 0) {
				mn = num[i / 2];
			}if(i % 3 ==0) {
				mn = Math.min(mn, num[i / 3]);
			}
			mn = Math.min(mn, num[i - 1]);
			num[i] = mn + 1;
		}
		
		System.out.println(num[N]);
	}
}
