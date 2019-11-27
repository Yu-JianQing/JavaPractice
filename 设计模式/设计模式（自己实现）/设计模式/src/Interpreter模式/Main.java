package Interpreter模式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String text=reader.readLine();
		
		Node node=new ProgramNode();
		node.parse(new Context(text));
		
		System.out.println(node);
		
		reader.close();
	}
}
