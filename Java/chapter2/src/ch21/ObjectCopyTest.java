package ch21;

public class ObjectCopyTest {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		Book[] copylibrary= new Book[5];
		
		library[0]= new Book("태백산맥1","조정래");
		library[1]= new Book("태백산맥2","조정래");
		library[2]= new Book("태백산맥3","조정래");
		library[3]= new Book("태백산맥4","조정래");
		library[4]= new Book("태백산맥5","조정래");
		
		copylibrary[0] = new Book();
		copylibrary[1] = new Book();
		copylibrary[2] = new Book();
		copylibrary[3] = new Book();
		copylibrary[4] = new Book();
		
		
		for(int i=0; i < copylibrary.length ; i++) {
			copylibrary[i].setAuthor(library[i].getAuthor());
			copylibrary[i].setTitle(library[i].getTitle());
		}
		System.arraycopy(library, 0, copylibrary, 0, 5);
		System.out.println("==libaray==");
		for(Book book:library) {
			System.out.println(book);
			book.showInfo();
		}
		
		System.out.println("==copy libaray==");
		for(Book book:copylibrary) {
			System.out.println(book);
			book.showInfo();
		}
	}

}
