package argotithm4;

//p.472 동전의 거스름 돈 구하기
public class DP_동전찾기 {
	public static void main(String[] args) {
		// 178원을 거슬러주세요!!
		int[] _1원 = new int[179];
		int[] _4원 = new int[179];
		int[] _6원 = new int[179];
		// 1원은 냅다 금액만큼 줘야해
		for (int i = 0; i <= 178; i++) {
			_1원[i] = i;
		}
		// 4원은 4원보다 큰 경우 4원을 뺏을때의 최적해에 4원 동전 하나를 얹는 경우와 1원으로만 처리했을때 중에 작은 값
		for (int i = 0; i <= 178; i++) {
			if(i>=4)
				_4원[i] = Math.min(_4원[i - 4] + 1, _1원[i]);
			else
				_4원[i] = _1원[i];
		}
		for (int i = 0; i <= 178; i++) {
			if(i>=6)
				_6원[i] = Math.min(_6원[i - 6] + 1, _4원[i]);
			else
				_6원[i] = _4원[i];
		}
		System.out.println(_6원[178]);
	}

}
