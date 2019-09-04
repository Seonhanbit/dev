package movie;

public class MovieMgr {
	
	private Movie[] movies = new Movie[100];
	private int index =0;
	
	private MovieMgr() {
		
	}
	private static MovieMgr instance;
	
	public synchronized static MovieMgr getInstance() {
		if(instance == null)
			instance = new MovieMgr();
		return instance;
	}
	
	public void add(Movie m) {
		if (index < 100) {
			movies[index] = m;
			index++;
		}
	}
	
	public Movie[] search() {
		System.out.println("모든 영화 정보");
		Movie[] mm = new Movie[index];
		for(int i = 0; i<index; i++) {
			mm[i] = movies[i];
		}
		return mm;
	}
	
	public Movie[] search(String title) {
		System.out.println(title+ "을 포함하고 있는 모든 영화 정보");
		int id =0;
		Movie[] m = new Movie[index];
		for(int i=0; i<index; i++) {
			if(title.equals(movies[i].getTitle())) {
				m[id] = movies[i];
				id++;
			}
		}
		return m;
	}
	
	

}
