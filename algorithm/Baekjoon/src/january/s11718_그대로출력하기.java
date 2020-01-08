package january;

import java.io.*;
import java.util.*;

public class s11718_그대로출력하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String str = "";

        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        
		bw.flush();
		bw.close();
	}
}
