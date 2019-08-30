package num2;

import org.springframework.stereotype.Component;

@Component
public class Tom {
	private Book book;
	
	public Tom(){}
	
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
