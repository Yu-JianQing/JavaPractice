package aboutUtil;

public class aboutRegex {
	public static void main(String[] args) {
		boolean bl1;
		String str="hello tom ,hi i am jerry.   CAT AND MOUSE  111589112";
		
		String regex1="[0-9]";
		String regex2="[a-z]";
		String regex3="[a-zA-Z]";
		String regex4="[3-4a-d]";
		String regex5="[a-h]+";
		String regex6="[a-h|0-5]+";
		String regex7="[^0123456789.]+";//Æ¥Åä·ÇÊý×Ö×Ö·û
		
//		String [] strings=str.split(regex1);
//		String [] strings=str.split(regex2);
//		String [] strings=str.split(regex3);
//		String [] strings=str.split(regex4);
//		String [] strings=str.split(regex5);
//		String [] strings=str.split(regex6);
		String [] strings=str.split(regex7);
		for(String string:strings)
			System.out.println(string);
		
	}
}
