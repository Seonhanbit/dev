package argorithm3;

public class 보이어무어 {
	static int skipTable[];
	public static void main(String[] args) {
		skipTable = new int[256];
		String str = "abcdloee yoe ve move. Plovse, love me. lovelovelove";
		String pattern = "love";
		genSkipTable(pattern);
		int found = search2(str, 0, pattern);
		while( found != -1 && found < str.length()) {
			System.out.println(found + "에서 패턴이 시작됩니다.");
			System.out.println(str.substring(found, found + pattern.length()));
			found = search2(str, found+pattern.length(), pattern);
		}
	}
	static void genSkipTable(String pattern) {
		//작성
		for (int i = 0; i < 256; i++)
			skipTable[i] = pattern.length();
		for (int i = 0; i < pattern.length(); i++)
			skipTable[pattern.charAt(i)] = pattern.length() - 1 - i;
		
	}
	static int search2(String str,int start_idx, String pattern) {
		int s_idx = start_idx + pattern.length()-1;
		int p_idx = pattern.length() - 1;
		while( p_idx >= 0 && s_idx < str.length() ) {
			while( str.charAt(s_idx) != pattern.charAt(p_idx) ) {
				int k  = skipTable[str.charAt(s_idx)];
				if( pattern.length() - p_idx > k ) {
					s_idx = s_idx + pattern.length() - p_idx;
				}
				else {
					s_idx += k;
				}
				if( s_idx >= str.length() )
					return -1;
				p_idx = pattern.length() -1;
			}
			p_idx--;
			s_idx--;
		}
		return s_idx+1;
	}
}
