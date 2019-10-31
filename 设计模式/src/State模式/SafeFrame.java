package Stateģʽ;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SafeFrame extends JFrame implements Context,ActionListener{
	private static final long serialVersionUID = 1L;
	
	private State state=DayState.getInstance();
	
	private JTextField field=new JTextField(35);
	private JTextArea area=new JTextArea(10, 35);
	private JButton use=new JButton("use");
	private JButton push=new JButton("push");
	private JButton talk=new JButton("talk");
	private JButton end=new JButton("end");
	
	
	public SafeFrame(String title){
		super(title);
		setLayout(new BorderLayout());
		add(field,BorderLayout.NORTH);
		field.setEditable(false);
		add(area,BorderLayout.CENTER);
		area.setEditable(false);
		JPanel panel=new JPanel();
		panel.add(use);panel.add(push);
		panel.add(talk);panel.add(end);
		add(panel,BorderLayout.SOUTH);
		
		setBounds(500, 600, 500, 400);
		setVisible(true);
		
		use.addActionListener(this);
		push.addActionListener(this);
		talk.addActionListener(this);
		end.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if(e.getSource()==use)
			state.doUse(this);
		else if(e.getSource()==push)
			state.doAlarm(this);
		else if(e.getSource()==talk)
			state.doPhone(this);
		else if(e.getSource()==end)
			System.exit(0);
		else
			System.out.println("?");
	}


	@Override
	public void changeState(State state) {
		this.state=state;
		System.out.println("change state");
	}


	@Override
	public void setClock(int hour) {
		String time="now time is :";
		if(hour<10)
			time=time+"0"+hour+":00";
		else
			time=time+hour+":00";
		field.setText(time);
		state.doClock(this, hour);
	}


	@Override
	public void dealCall(String msg) {
		area.append(msg+"\n");
	}


	@Override
	public void recordLog(String msg) {
		area.append("record..."+msg+"\n");
	}

}
