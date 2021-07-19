import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
	static int N, M, start, destination;
	static int res[];
	static ArrayList<Data> list[];
	static PriorityQueue<Data> pq;
	static class Data implements Comparable<Data>{
		int dest;
		int cost;
		public Data(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Data o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		res = new int [N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new Data(y, z));
			
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());
		
		Arrays.fill(res, 2147000000);
		dijkstra();
		System.out.println(res[destination]);
	}
	
	static void dijkstra() {

		PriorityQueue<Data> pq = new PriorityQueue<>();
		res[start] = 0;
		pq.add(new Data(start, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			if(res[cur.dest] < cur.cost)
				continue;
			
			for (Data next : list[cur.dest]) {
				if(res[next.dest] > next.cost + res[cur.dest]) {
					res[next.dest] = next.cost + res[cur.dest];
					pq.add(new Data(next.dest, res[next.dest]));
				}
			}
		}
	}
}
