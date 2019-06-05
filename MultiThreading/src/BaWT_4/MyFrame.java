package BaWT_4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final JLabel lab=new JLabel("time");
	private final JButton btn=new JButton("start");
	private boolean working=false;
	
	public MyFrame(){
		super("my frame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(lab);
		getContentPane().add(btn);
		btn.addActionListener(this);
		setBounds(600, 700, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void timeStart(){
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"   "+i);
			lab.setText(" "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		working=false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn){
			if(working==true)
				return ;
			working=true;
			new Thread(){
				public void run(){
					timeStart();
				}
			}.start();
		}
	}

}
