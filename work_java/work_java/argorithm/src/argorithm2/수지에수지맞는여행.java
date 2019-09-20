package argorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지에수지맞는여행 {
	public static boolean visited[][];
	public static boolean check[];
	public static int ans;
	public static class pair{
		int x;
		int y;
		char a;
		public pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			m = 0;
			String str=br.readLine();
			StringTokenizer st=new StringTokenizer(str);
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			char[][]arr=new char[R][C];
			for(int row=0;row<R;row++) {
				str=br.readLine();
				for(int col=0;col<C;col++) {
					arr[row][col]=str.charAt(col);
				}
			}
//			for(int row=0;row<R;row++) {
//				for(int col=0;col<C;col++) {
//					System.out.print(arr[row][col]);
//				}
//				System.out.println();
//			}
			//visited=new boolean[R][C];
			check=new boolean[26];
			//visited[0][0]=true;
			check[arr[0][0]-'A']=true;
			dfs(arr,0,0,R,C,0);
			System.out.println("#"+tc+" "+(m+1));
		}
	}
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int m=0;
	public static int cnt=1;
	public static void dfs(char[][] arr,int x, int y, int R, int C,int cnt) {
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&nx<R&&ny>=0&&ny<C&&!check[arr[nx][ny]-'A']) {
				check[arr[nx][ny]-'A']=true;
				dfs(arr,nx,ny,R,C,cnt+1);
				check[arr[nx][ny]-'A']=false;
				
			}
			else {
				if(cnt>m)
					m=cnt;
				return;
			}
		}
		
	}
	

}
