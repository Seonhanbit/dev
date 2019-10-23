import java.io.*;
import java.util.*;

public class Baek_1149 {
	 static class Color{
	        
	        int r;
	        int g;
	        int b;
	        
	        public Color() {}
	        public Color(int r, int g, int b) {
	            this.r = r;
	            this.g = g;
	            this.b = b;
	        }
	        @Override
	        public String toString() {
	            return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	        }
	    }
	    
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int n = Integer.parseInt(bf.readLine());
	        Color[] c = new Color[n];
	        int[][] sum = new int[n+1][3];
	        
	        for(int i=0; i<n; i++) {
	            
	            StringTokenizer st = new StringTokenizer(bf.readLine());
	            int rcost = Integer.parseInt(st.nextToken());
	            int gcost = Integer.parseInt(st.nextToken());
	            int bcost = Integer.parseInt(st.nextToken());
	            c[i] = new Color(rcost, gcost, bcost);
	        }
	        
	        for(int i=1; i<=n; i++) {
	            
	            sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + c[i-1].r;
	            sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + c[i-1].g;
	            sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + c[i-1].b;
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for(int i=0; i<3; i++) {
	            
	            if(min > sum[n][i])
	                min = sum[n][i];
	        }
	        
	        bw.write(min +"\n");
	        bw.flush();
	        bw.close();
	    }
}
