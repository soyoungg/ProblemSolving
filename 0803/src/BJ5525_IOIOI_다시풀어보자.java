import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 50 점 맞았음 KMP 등 다른 알고리즘 적용해서 다시 풀어보기
public class BJ5525_IOIOI_다시풀어보자 {
	static int N, M;
	static String s;
	static int res;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = st.nextToken();
		StringBuilder sb =  new StringBuilder();
		sb.append("I");
		
		for (int i = 0; i < N; i++) {
			sb.append("OI");
		}
		int sbLeng = sb.length();
		int sLeng = s.length() - sbLeng + 1;
		for (int i = 0; i < sLeng; i++) {
			for (int j = 0; j < sbLeng; j++) {
				if(s.charAt(i + j) != sb.charAt(j)) {
					flag = true;
					break;
				}
			}
			if(!flag)
				res++;
			flag = false;
		}
		System.out.println(res);
	}
}
