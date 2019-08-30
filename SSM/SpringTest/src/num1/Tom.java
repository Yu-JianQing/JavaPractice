package num1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tom {
	@Autowired
	private Book book;
	
//	@Autowired
//	public Tom(Book book){
//		this.book=book;
//	}

	public Book getBook() {
		return book;
	}

//	@Autowired
//	public void setBook(Book book) {
//		this.book = book;
//	}
	
}
