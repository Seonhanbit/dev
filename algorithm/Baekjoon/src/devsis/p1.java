package devsis;

import java.io.*;
import java.util.*;

public class p1 {
	static public int solution(String[] names) {
	      int answer = 0;

	      //제한 조건이 name가 최대 100개만 들어오니까 미리 51개로 설정.
	      //4명일때는 2+2이니까 1쌍+1쌍 -> 조합 경우의 수를 미리 arr 담아둔 것
	      int[] arr = new int[51];
	      for (int i = 3; i < arr.length; i++) {
	    	  //왼쪽 집단, 오른쪽 집단 두 그룹으로 나누기.
	         int left = i / 2;
	         int right = i - left;
	         for (int j = 1; j < left; j++)
	            arr[i] += j;
	         for (int j = 1; j < right; j++)
	            arr[i] += j;
	      }

	      int[] alphabet = new int[26];
	      for (int i = 0; i < names.length; i++)
	         alphabet[names[i].charAt(0) - 'a']++;

	      for (int i = 0; i < alphabet.length; i++)
	         if (alphabet[i] > 0)
	            answer += arr[alphabet[i]];

	      return answer;
	   }

	   public static void main(String[] args) {
	      int ans = solution(new String[] { "lemon", "lime", "werewolf", "wizard", "walnut" });
//	      int ans = solution(new String[] { "gin", "gin", "gum", "salt", "str", "soda", "beet", "black" });
//	      int ans = solution(new String[] { "soda", "soda", "soda", "soda", "soda" });
	      System.out.println(ans);
	   }

}
