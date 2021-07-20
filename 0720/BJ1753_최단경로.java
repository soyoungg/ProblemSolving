import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {
	static int V, E, K;
	static PriorityQueue<Data> pq;
	static ArrayList<Data> list[];
	static int res[];
	static class Data implements Comparable<Data>{
		int dest;
		int weight;
		public Data(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		res = new int [V + 1];
		Arrays.fill(res, 2147000000);
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine()); // 시작 정점
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Data(b, c));
		}
		
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			if(res[i] == 2147000000)
				System.out.println("INF");
			else
				System.out.println(res[i]);
		}
	}
	
	public static void dijkstra() {
		pq = new PriorityQueue<>();
		res[K] = 0;
		pq.add(new Data(K, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
			if(res[cur.dest] < cur.weight)
				continue;
			
			for (Data next : list[cur.dest]) {
				if(res[next.dest] > next.weight + res[cur.dest]) {
					res[next.dest] = next.weight + res[cur.dest];
					pq.add(new Data(next.dest, res[next.dest]));
				}
			}
		}
	}
}
