package ws_java_0729_03_선한빛;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManager man = new BookManager();
		
		man.addBook(new Book("22222", "Javaro", "김하나", "Jaen.kr", 15000, "Java 기본 문법"));
		man.addBook(new Book("55555", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링"));
		man.addBook(new Book("44444", "분석 공학", "대나무", "Jren.kr", 45000, "분석 기법"));
		man.addBook(new Magazine("101", "프로 듀스", "나야나", "producor.kr", 100000, "덕후", 2019, 1));
		man.addBook(new Magazine("102", "매거진임 ", "너야너", "producer.or", 280000, "덕후", 2015, 2));
		man.addBook(new Magazine("103", "맥심 ", "누구야", "producer.or", 380000, "덕후", 2013, 8));
		
		man.search();
		man.searchIsbn("22222");
		man.title("프로 듀스");
		man.book();
		man.magazine();
		man.searchMag();
		man.출판사("Jren.kr");
		man.가격(100000);
		man.금액합();
		man.금액평균();
		
	}

}
