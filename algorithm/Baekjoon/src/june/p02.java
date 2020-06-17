package june;

import java.io.*;
import java.util.*;

public class p02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr1 = { 46, 33, 33 ,22, 31, 50 };
		int[] arr2 = {27 ,56, 19, 14, 14, 10 };
		solution(6, arr1, arr2);
	}

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] mok = new int[n];
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		
        	}
        }
        return answer;
    }
}
