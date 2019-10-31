package Iteratorģʽ;

public class BookShelf implements Aggregate{
	private BooK[] books;
	
	private int last=0;
	
	public BookShelf(int bookMax){
		this.books=new BooK[bookMax];
	}
	
	public BooK getBooKAt(int index){
		return books[index];
	}
	
	public void appendBook(BooK book){
		books[last]=book;
		last++;
	}
	
	public int getSize(){
		return last;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
	
	
	
}
