package Iteratorģʽ;

public class BookShelfIterator implements Iterator{
	private BookShelf bookShelf;
	
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf=bookShelf;
		this.index=0;
	}
	
	@Override
	public boolean hasNext() {
		if(index<bookShelf.getSize())
			return true;
		return false;
	}

	@Override
	public Object next() {
		BooK book=bookShelf.getBooKAt(index);
		index++;
		return book;
	}

}
