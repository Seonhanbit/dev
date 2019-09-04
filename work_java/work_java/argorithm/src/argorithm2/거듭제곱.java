package argorithm2;

public class 거듭제곱 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pow(1,5000);
		pow2(1,5000);
		System.out.println(cnt1);
		System.out.println(cnt2);
	}

	//얼마나 호출될까?
	static int cnt1 = 0;
	static int cnt2 = 0;

	// 무식하게 짜보기
	static int pow2(int a, int b) {
		cnt2++;
		if (b == 1)
			return 0;
		if (b == 0)
			return 1;
		return a * pow2(a, b - 1);
	}

	// 분할정복
	static int pow(int a, int b) {
		cnt1++;
		if (b == 1) {
			return a;
		}
		if (b == 0) {
			return 1;
		}

		int tmp = pow(a, b / 2); // a의 b/2승

		if (b % 2 == 1) {
			return tmp * tmp * a;
		} else {
			return tmp * tmp;
		}
	}

}
