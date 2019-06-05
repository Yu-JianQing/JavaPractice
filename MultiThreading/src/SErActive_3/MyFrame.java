package SErActive_3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	JTextField textField=new JTextField("word",10);
	JButton button=new JButton("search");
	JTextArea textArea=new JTextArea(20, 30);
	JLabel label=new JLabel("Search");
	JPanel panel=new JPanel();
	Thread thread=null;
	
	public MyFrame(){
		super("my frame");
		
		setLayout(new BorderLayout());
		
		panel.add(label);
		panel.add(textField);
		panel.add(button);
		add(panel,BorderLayout.NORTH);
		add(textArea,BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 600,300,500);
		
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(thread!=null)
			return ;
		thread=new Thread(){
			public void run(){
				String word=textField.getText();
				
				ActiveObject activeObject=ActiveObjectFactory.CreateActiveObjects();
				Result<String> result=activeObject.search(word);
				String value=result.getValue();
				
				textArea.setText(value);
			}
		};
		
		thread.start();
	}
	
}
