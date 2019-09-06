package car;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CarMgr man = new CarMgr();
		CarMgr man = CarMgr.getInstance();

		man.addCar(new Car("111", "벤츠", 30000));
		man.addCar(new Car("222", "기아자동차", 80000));
		man.addCar(new Car("333", "현대", 50000));
		
		
		Car c8 = new Bus("444", "나는 버스다", 40000, 12);
		Car c7 = new Bus("222", "나는 22버스다", 40000, 12);
		
		if(c7 instanceof Bus) {
			System.out.println(c7.toString());
		}
		
		man.addCar(new Truck("555", "나는 트럭이다", 88888, 50));
		
		System.out.println(c8.toString());

		Car[] c = man.search();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}

		System.out.println("=====");

		System.out.println(man.search("111"));

		System.out.println("=====");

		Car[] cPrice = man.search(60000);
		for (int i = 0; i < man.len(); i++) {
			System.out.println(cPrice[i]);
		}
		
		
		man.update("111", 23);
		Car[] c1 = man.search();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c1[i]);
		}
		System.out.println("=====");
		
		man.delete("111");
		
		Car[] c2 = man.search();
		for (int i = 0; i < c2.length; i++) {
			System.out.println(c2[i]);
		}
		System.out.println("=====");
		
		System.out.println(man.size());
		System.out.println(man.totalPrice());

	}

}
