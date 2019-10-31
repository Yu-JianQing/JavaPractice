package Commandģʽ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener,MouseMotionListener,WindowListener{
	private static final long serialVersionUID = 1L;
	
	private MacroCommand commands=new MacroCommand();
	private DrawCanvas drawCanvas=new DrawCanvas(400, 400, commands);
	
	private JButton clearButton=new JButton("clear");
	private JButton undoButton=new JButton("undo");
	
	public MyFrame(String titile){
		super(titile);
		
		Box butBox=new Box(BoxLayout.X_AXIS);
		butBox.add(clearButton);
		butBox.add(undoButton);
		Box mainBox=new Box(BoxLayout.Y_AXIS);
		mainBox.add(butBox);
		mainBox.add(drawCanvas);
		getContentPane().add(mainBox);
		
		this.addWindowListener(this);
		drawCanvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);
		undoButton.addActionListener(this);
		
		setBounds(500,600,500,400);
		this.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command command=new DrawCommand(drawCanvas, e.getPoint());
		commands.add(command);
		command.execute();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clearButton){
			commands.clear();
			drawCanvas.repaint();
		}else if(e.getSource()==undoButton){
			commands.undo();
			drawCanvas.repaint();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
	
}
