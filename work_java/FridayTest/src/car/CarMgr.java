package car;

public class CarMgr {

	private Car[] cars;
	private int index = 0;
	private int max = 100;
	private int idx =0;

	//싱글턴패턴
	private CarMgr() {};
	private static CarMgr instance;
	public synchronized static CarMgr getInstance() {
		if(instance == null)
			instance = new CarMgr();
		return instance;
	}
	
	//if 빼는 방법 
//	private static CarMgr instance = new CarMgr();
	
//	public CarMgr() {
//		cars = new Car[max];
//	}

	public void addCar(Car c) {
		if (index < max) {
			cars[index] = c;
			index++;
		} else {
			Car[] tmp = new Car[max * 2];
			max *= 2;
			System.arraycopy(cars, 0, tmp, 0, cars.length);
			cars = tmp; // 위치를 알려주는 것. cars 주소 값이 tmp로 바뀜 
			cars[index] = c;
			index++;
		}
	}

	// 현재 저장된 모든 차량 정보 리턴
	public Car[] search() {
		Car[] c = new Car[index];
		for(int i=0; i<index; i++) {
			c[i] = cars[i];
		}
		return c;
	}
	
	//파라메터로 전달된 번호와 같은 차량 정보를  리턴
	public Car search(String num) {
		for (int i = 0; i < index; i++) {
			if (num.equals(cars[i].getNum())) {
				return cars[i];
			}
		}
		return null;
	}

	// 가격보다 작은 차량 정보 리턴
	public Car[] search(int price) {
		Car[] c = new Car[100];
		idx = 0;
		
		for (int i = 0; i < index; i++) {
			if (cars[i].getPrice() < price) {
				c[idx] = cars[i];
				idx++;
			}
		}
		return c;
	}
	
	public int len() {
		return idx;
	}

	// 차량 검색 후 가격 수정
	public void update(String num, int price) {
		System.out.println(price + "해당 값으로 수정합니다.");
		for (int i = 0; i < index; i++) {
			if (num.equals(cars[i].getNum())) {
				cars[i].setPrice(price);
			}
		}
	}

	// 차량을 삭제하기
	public void delete(String num) {
		for(int i =0; i<index; i++) {
			if(num.equals(cars[i].getNum())) {
				//앞으로 밀착
				for(int j=i+1; j< index;j++) {
					cars[j-1] = cars[j];
				}
				index--;
//				cars[i] = cars[index -1];
//				index--;
			}
		}

	}

	// 배열에 저장된 차량 대수 리턴
	public int size() {
		System.out.println("저장된 모든 차량 대수 : ");
		return index+1;

	}

	// 차량 금액 합계
	public int totalPrice() {
		System.out.println("저장된 모든 차량의 금액 합계 : ");
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += cars[i].getPrice();
		}
		return sum;
	}

}
