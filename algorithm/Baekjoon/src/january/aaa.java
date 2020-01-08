package january;

import java.io.*;
import java.util.*;

public class aaa {
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
