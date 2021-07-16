import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1138_한줄로서기 {
	static int row[], line[];
	static int N, here,  jari;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		row = new int [N + 1];
		line = new int [N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			row[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(line, -1);
		
		for (int i = 1; i < N; i++) {
			int cnt = 0;
			here = row[i];
			
			for (int j = 1; j <= N; j++) {
				if(cnt == here && line[j] < 0) {
					here = j;
					break;
				}
				if(line[j] == -1) {
					cnt++;
				}
				if(line[j] > 0)
					continue;
				
			}
			
			line[here] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			if(line[i] == -1)
				line[i] = N;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(line[i] + " ");
		}
	}
}
