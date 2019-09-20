package September;

import java.util.Scanner;

public class 구슬탈출2_답 {
	static int N;
	static int M;
	static char[][]map;
	static boolean [][][][]visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//빨간구슬 파란구슬을 직접 2차원배열 위에서 이동시키기 보다는 빨간구슬 , 파란구슬의 좌표를 기억하고 다니면서 검사하는게 수월.
		//(2,2),(2,9),0 ->하나의 상태노드..
		//상 하 좌 우로 만든다.상태공간트리를 생각할것...그리기..
		//프루닝을 생각해볼 것.(좌표가 같으면 할 필요 없다.)
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[N][M];
		visited=new boolean[N][M][N][M];
		//빨간공 행렬, 파랑공 행렬
		int rr=0, rc=0, br=0, bc=0;
		for(int i=0;i<N;i++) {
			String line=sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='R') {
					rr=i;
					rc=j;
					map[i][j]='.';
					break;
				}
				else if(map[i][j]=='B') {
					br=i;
					bc=j;
					map[i][j]='.';
					break;
				}
			}
		}
		visited[rr][rc][br][bc]=true;
		dfs(rr,rc,br,bc,0);
	}
	static int[]dr= {-1,1,0,0};
	static int[]dc= {0,0,-1,1};
	static int ans=987654421;
	static void dfs(int rr, int rc, int br, int bc, int cnt) {
		//10번 이상 흔들었으면 탈락
		if(cnt>10)
			return;
		//파랑공빠지면 탈락
		if(map[br][bc]=='O')
			return;
		if(map[rr][rc]=='O') {
			//정답후보
			ans=Math.min(ans, cnt);
			return;
		}
		for(int i=0;i<4;i++) {
			int nrr=rr;
			int nrc=rc;
			int nbr=br;
			int nbc=bc;
			//빨간공을 굴린다..이부분 생각을 못했다...
			while(true) {
				if(map[nrr][nrc]=='#') {
					nrr-=dr[i];
					nrc-=dc[i];
					break;
				}
				if(map[nrr][nrc]=='O') {
					break;
				}
				nrr+=dr[i];
				nrc+=dc[i];
			}
			while(true) {
				if(map[nbr][nbc]=='#') {
					nbr-=dr[i];
					nbc-=dc[i];
					break;
				}
				if(map[nbr][nbc]=='O') {
					break;
				}
				nbr+=dr[i];
				nbc+=dc[i];
			}
			if(nrr==nbr&&nrc==nbc&&map[nbr][nbc]!='O') {
				if(i==0) {
					if(rr<br)
						nbr--;
					else
						nrr--;
				}else if(i==1) {
					if(rr<br)
						nrr--;
					else
						nbr--;
				}else if(i==2) {
					if(rc<bc)
						nrc++;
					else
						nbc++;
				}else if(i==3) {
					if(rc<bc)
						nrc--;
					else
						nbc--;
				}
			}
			if(!visited[nrr][nrc][nbr][nbc]) {
				visited[nrr][nrc][nbr][nbc]=true;
				dfs(nrr,nrc,nbr,nbc,cnt+1);
				visited[nrr][nrc][nbr][nbc]=false;
			}
		}
	}

}
