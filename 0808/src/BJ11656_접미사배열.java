import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11656_접미사배열 {
	static String origin;
	static String sub[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		origin = br.readLine();
		int N = origin.length(); 
		sub = new String[N];
		sub[0] = origin;
		
		for (int i = 1; i < N; i++) {
			sub[i] = sub[i - 1].substring(1);
		}
		Arrays.sort(sub);
		for (String s: sub) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
