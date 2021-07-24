import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10773_제로 {
	static int N, res;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		stack = new Stack<>();
		int N =  Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp != 0) {
				stack.add(tmp);
			}else {
				stack.pop();
			}
		}
		
		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		
		System.out.println(res);
	}
}
