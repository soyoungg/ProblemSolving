import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2606_바이러스 {
	static ArrayList<Integer> list[];
	static int N, M;
	static int res;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList [N + 1];
		visited = new boolean [N + 1];
		
		for (int i = 1; i <= N; i++) 
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		visited[1] = true;
		go(1);
		
		System.out.println(res);
	}
	
	static void go(int start) {
		for (int i = 0; i < list[start].size(); i++) {
			if(!visited[list[start].get(i)]) {
				visited[list[start].get(i)] = true;
				res++;
				go(list[start].get(i));
			}
		}
	}
}
