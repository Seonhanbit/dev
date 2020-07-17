package NDS;

public class sol1 {

	public static void main(String[] args) {
		String str = solution("Jackdaws love my big sphinx of quartz");
		System.out.println(str);
	}

	public static String solution(String sentence) {
		String answer = "";
		sentence = sentence.toLowerCase();
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		boolean[] ckarr = new boolean[26];
		for (int i = 0; i < sentence.length(); i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == sentence.charAt(i)) {
					ckarr[j] = true;
					break;
				}
			}
		}
		
		for (int j = 0; j < arr.length; j++) {
			if(!ckarr[j])
				answer += arr[j];
		}
		if(answer=="")
			answer = "perfect";
		return answer;
	}

}
