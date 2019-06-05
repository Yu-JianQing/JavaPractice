package BaWT_4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyFrame_2 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final JLabel lab=new JLabel("time");
	private final JButton btn=new JButton("start");
	
	public MyFrame_2(){
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
		try {
			for (int i = 0; i < 10; i++) {
				String str=" "+i;
				final Runnable executor=new Runnable() {
					public void run() {
						lab.setText(str);
						System.out.println(Thread.currentThread().getName()+"   "+str);
					}
				};
				SwingUtilities.invokeLater(executor);
				Thread.sleep(1000);
			}	
		} catch (InterruptedException e) {}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn){
			new Thread(){
				public void run(){
					timeStart();
				}
			}.start();
		}
	}

}
