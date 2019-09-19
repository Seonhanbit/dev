package argorithm3;

import java.util.*;

public class SuffixArray {
	public static void main(String[] args) {
		String s = "banana";
		//s문자열의 모든 접미사 생성 - 실제 문자열을 생성하지 않고 시작 문자의 위치를 기록
		Integer[] sa = new Integer[s.length()];
		for(int i = 0; i < sa.length; i++)
			sa[i] = i;
		//sa[i]번째 부터 시작하는 문자열들이 각각 사전순으로 오름차순이 되도록 정렬.
		//sa[0] : banana  ↔ sa[1] : anana 
		//s.subString(sa[0])     s.subString(sa[1])
		Arrays.sort(sa, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return s.substring(o1).compareTo(s.substring(o2));
			}
		});
		System.out.println(Arrays.toString(sa));
		int[] LCP = new int[s.length()];
		//LCP를 구해보시오.
		for(int i = 1; i < LCP.length; i++) {
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while( s1.length() > LCP[i] && s2.length() > LCP[i]&&s1.charAt(LCP[i]) == s2.charAt(LCP[i]) ) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP));
		
		int k = 9;
		//k번째 부분문자열 찾기...
		for(int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]);
//			System.out.print(i + " 번째 접미사에서 나오는 부분문자열의 갯수 : ");
//			System.out.println(str.length() - LCP[i]);
			if( k - (str.length() - LCP[i]) > 0)
				k = k- (str.length() - LCP[i]);
			else {
//				System.out.println(i + " 번째 접미사, 여기에 답있다.");
				System.out.println(str.substring(0, k + LCP[i]));
				break;
			}
		}
	}
}
