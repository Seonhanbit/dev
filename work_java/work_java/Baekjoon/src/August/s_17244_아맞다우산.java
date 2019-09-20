package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_17244_아맞다우산 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//최대한 빠르게 물건을 챙겨서 외출하는 이동경로
		//상하좌우 인접한 칸- 한걸음
		//물건을 모두 챙겨서 외출하기까지 최소 몇걸음이 필요한가.
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int col=Integer.parseInt(st.nextToken());
		int row=Integer.parseInt(st.nextToken());
		char[][] arr=new char[row][col];
		for(int r=0;r<row;r++) {
			str=br.readLine();
			for(int c=0;c<col;c++) {
				arr[r][c]=str.charAt(c);
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
