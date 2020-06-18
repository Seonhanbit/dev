package june;

import java.io.*;
import java.util.*;

public class p3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		//solution(6, arr1, arr2);
	}

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
        	int tmp = Integer.parseInt(arr[i]);
        	if(tmp>max)
        		max = tmp;
        	if(tmp<min)
        		min = tmp;
        }
        answer = max+" "+min;
        return answer;
    }
}
