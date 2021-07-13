import java.util.Scanner;

public class BJ1748_수이어쓰기1 {
	static int i,number, digit, len, total;
	static long size;
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str =  sc.next();
		len = str.length();
		number = Integer.parseInt(str);
		digit = 9;
		
		for (i = 1; i < len; i++) {
			size = size + (digit * i);
			total += digit;
			digit *= 10;
		}
		
		size = size + (number - total) * i;
		
		System.out.println(size);
	}
}
