package aboutFileExample;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDKWindow extends JFrame implements ActionListener{
	JTextField textField1,textField2;
	JButton edit,compile,run;
	JLabel label1,label2;
	
	public JDKWindow(){
		edit=new JButton("edit");
		compile=new JButton("compile");
		run=new JButton("run");
		textField1=new JTextField(10);
		textField2=new JTextField(10);
		label1=new JLabel("输入源文件名：");
		label2=new JLabel("输入主类名：");
		
		setLayout(new FlowLayout());
		
		add(edit);
		add(label1);
		add(textField1);
		add(compile);
		add(label2);
		add(textField2);
		add(run);
		
		edit.addActionListener(this);
		compile.addActionListener(this);
		run.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,600,750,100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==edit) {
			
		}else if (e.getSource()==compile) {
			
		}else if (e.getSource()==run) {
			
		}
		
	}
}
