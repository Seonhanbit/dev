package hw_java_0723;

public class ProductMgr {
	private Product[] pArr;
	private int max = 10;
	private int index = 0;

	public ProductMgr() {
		pArr = new Product[max];
	}

	// 데이터 입력
	public void addBook(Product p) {
		if (index < max) {
			pArr[index] = p;
			index++;
		} else {// 배열카피
			Product[] temp = new Product[max * 2]; // 주소값
			max *= 2;
			System.arraycopy(pArr, 0, temp, 0, pArr.length);
			pArr = temp;
			pArr[index] = p;
			index++;
		}
	}

	// 상품 정보를 전체 검색
	public void search() {
		for (int i = 0; i < index; i++) {
			System.out.println(pArr[i].toString());
		}
	}

	// num
	public void searchNum(int num) {
		System.out.println(num + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (num == pArr[i].getNum()) {
				System.out.println(pArr[i].toString());
			}
		}
	}

	// 상품명
	public void title(String name) {
		System.out.println(name + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (name.equals(pArr[i].getName())) {
				System.out.println(pArr[i].toString());
			}
		}
	}

	// TV정보만 검색
	public void TV() {
		System.out.println("TV만으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (pArr[i] instanceof TV) {
				System.out.println(pArr[i].toString());
			}
		}

	}

	// Refrigerator
	public void Refrigerator() {
		System.out.println("Refrigerator만으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (pArr[i] instanceof Refrigerator) {
				System.out.println(pArr[i].toString());
			}
		}
	}

	// 상품 번호로 상품 삭제
	public void 상품번호(int num) {
		System.out.println(num + "상품을 삭제합니다.");
		for (int i = 0; i < index; i++) {
			if (num == pArr[i].getNum()) {
				for (int j = i + 1; j < index; j++) {
					pArr[j - 1] = pArr[j];
				}
				index--;
			}
		}
	}

	// 금액합
	public void 금액합() {
		System.out.println("저장된 모든 상품의 금액 합계 : ");
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += pArr[i].getPrice();
		}
		System.out.println(sum);
	}

}
