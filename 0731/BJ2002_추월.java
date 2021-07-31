import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ2002_추월 {
	static int N, res;
	static String origin[];
	static String end[];
	static boolean check[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		origin = new String [N];
		end = new String [N];
		check = new boolean [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			origin[i] = st.nextToken();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			end[i] = st.nextToken();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String goal = origin[i];
				if(end[j].equals(goal)) {
					check[j] = true;
					break;
				}
				if(!check[j]) {
					res++;
					check[j] = true;
				}
			}
		}
		System.out.println(res);
	}
}
