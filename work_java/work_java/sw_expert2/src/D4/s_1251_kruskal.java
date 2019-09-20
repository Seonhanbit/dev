package D4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class s_1251_kruskal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			double[][] points = new double[V][2];
			for(int i=0; i<V; i++) {
				points[i][0]= sc.nextDouble();
			}
			for(int i=0; i<V; i++) {
				points[i][1]= sc.nextDouble();
			}
			double E = sc.nextDouble();
			//모든 간선의 개수는 최대 A 
			int A = V*(V-1)/2;
			double[][] edges = new double[A][3];
			int idx = 0;
			for(int i=0; i<V; i++) {
				//i번째 정점을 시작점으로 두고
				double x1 = points[i][0];
				double y1 = points[i][1];
				for(int j=i+1; j<V; j++) {
					//j번째 정점까지의 거리를 계산해서 간선배열에 기록
					double x2 = points[j][0];
					double y2 = points[j][1];
					//x1y1부터 x2y2의 거리
					double L = (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2))*E;
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = L;
					idx++;
				}
			}
			//간선을 경로 비용으로 정렬
			Arrays.sort(edges, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1[2], o2[2]);
				}
			});
			parents = new int[V];
			for(int i=0; i<V; i++)
				parents[i]=i;
			double result = 0;
			int cnt = 0;
			for(int i=0; i<A; i++) {
				int a = find((int)edges[i][0]);
				int b = find((int)edges[i][1]);
				if(a!=b) {
					union(a,b);
					result +=edges[i][2];
					cnt++;
				}
				if(cnt==V-1)
					break;
			}
			System.out.println("#"+tc+" " +(long)Math.round(result));
		}
	}
	static int[] parents;
	static int find(int x) {
		if(x==parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	static void union(int x, int y) {
		parents[find(x)] = find(y);
	}

}
