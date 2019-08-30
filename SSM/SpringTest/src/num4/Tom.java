package num4;

import org.springframework.stereotype.Component;

@Component
public class Tom {
	private Book book;
	
	public Tom(Book book){
		this.book=book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
