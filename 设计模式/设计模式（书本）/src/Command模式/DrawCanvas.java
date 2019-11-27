package Commandģʽ;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable{
	private static final long serialVersionUID = 1L;
	
	private Color color=Color.red;
	private int radius=6;
	private MacroCommand commands;
	
	public DrawCanvas(int width,int height,MacroCommand commands){
		setSize(width,height);
		setBackground(Color.white);
		this.commands=commands;
	}

	@Override
	public void draw(int x, int y) {
		Graphics g=getGraphics();
		g.setColor(color);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}
	
	public void paint(Graphics g){
		commands.execute();
	}

}
