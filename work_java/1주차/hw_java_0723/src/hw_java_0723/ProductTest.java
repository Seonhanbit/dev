package hw_java_0723;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductMgr man = new ProductMgr();
		
		//데이터 입력기능 
		man.addBook(new TV(111, "첫번째티비", 20000, 4, 24));
		man.addBook(new TV(222, "삼성꺼티비", 80000, 8, 60));
		man.addBook(new TV(333, "엘지꺼티비", 30000, 3, 30));
		
		man.addBook(new Refrigerator(999, "삼성냉장고", 80000, 80, 120));
		man.addBook(new Refrigerator(888, "엘지냉장고", 40000, 40, 100));
		man.addBook(new Refrigerator(777, "추워냉장고", 20000, 30, 600));
		
		man.search();
		man.searchNum(333);
		
		man.searchNum(999);
		
		man.title("삼성냉장고");
		man.TV();
		man.Refrigerator();
		
		man.상품번호(111);
		
		man.search();
		man.금액합();
		
	}

}
