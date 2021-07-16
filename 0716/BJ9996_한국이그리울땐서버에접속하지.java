import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9996_한국이그리울땐서버에접속하지 {
	static int N;
	static String origin, left, right;
	static String input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), "*");
		left = st.nextToken();
		right = st.nextToken();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			if(input.length() < left.length() + right.length())
				System.out.println("NE");
			else {
				String tmp_l = input.substring(0, left.length());
				String tmp_r = input.substring(input.length() - right.length(), input.length());
				
				if(tmp_l.equals(left) && tmp_r.equals(right))
					System.out.println("DA");
				else
					System.out.println("NE");
			}
		}
	}
}
