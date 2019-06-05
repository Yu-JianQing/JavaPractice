package ShiTPT_7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final JButton exeBtn=new JButton("execute");
	private final JButton celBtn=new JButton("cancel");
	
	public MyFrame(){
		super("My Frame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JLabel("sample"));
		getContentPane().add(exeBtn);
		getContentPane().add(celBtn);
		exeBtn.addActionListener(this);
		celBtn.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 700, 100, 400);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exeBtn){
			Service.service();
		}else if (e.getSource()==celBtn){
			Service.cancel();
		}
			
		
	}

}
