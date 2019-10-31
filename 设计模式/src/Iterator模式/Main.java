package Iteratorģʽ;

public class Main {
	public static void main(String[] args) {
		BooK b1=new BooK("a");
		BooK b2=new BooK("b");
		BookShelf bookShelf=new BookShelf(5);
		bookShelf.appendBook(b1);
		bookShelf.appendBook(b2);
		
		Iterator iterator=bookShelf.iterator();
		
		while(iterator.hasNext()){
			BooK book=(BooK) iterator.next();
			System.out.println(book.getName());
		}
	}
}
