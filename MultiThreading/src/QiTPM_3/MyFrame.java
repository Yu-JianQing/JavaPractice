package QiTPM_3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener{
	public MyFrame(){
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JLabel("xxxxxxxxx"));
		JButton btn=new JButton("Execute");
		getContentPane().add(btn);
		btn.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setBounds(500, 500, 300, 100);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		Service.service();
//		Service_2.service();
//		Service_3.service();
		Service_4.service();
	}
}
