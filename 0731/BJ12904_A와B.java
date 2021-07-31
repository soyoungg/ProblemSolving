import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12904_A와B {
	static String origin;
	static String goal;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		origin = st.nextToken();
		st = new StringTokenizer(br.readLine());
		goal = st.nextToken();
		while(goal.length() != origin.length()) {
			int leng = goal.length();
			char lastChar = goal.charAt(leng - 1);
			
			String newGoal = goal.substring(0, leng - 1);
			goal = new String(newGoal);
			if(lastChar == 'B') {
				StringBuilder sb = new StringBuilder(goal);
				String reversed = sb.reverse().toString();
				goal = new String(reversed);
			}
		}
		
		if(goal.equals(origin)) {
			res = 1;
		}else {
			res = 0;
		}
		
		System.out.println(res);
	}
}
