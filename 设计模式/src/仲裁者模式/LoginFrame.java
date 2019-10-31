package ÖÙ²ÃÕßÄ£Ê½;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginFrame extends JFrame implements ActionListener,Mediator{
	private static final long serialVersionUID = 1L;

	private ColleagueRadioButton guestRadio,userRadio;
	
	private ColleagueTextFiled name,pwd;
	
	private ColleagueButton login,cancle;
	
	public LoginFrame(String title){
		super(title);
		setLayout(new GridLayout(4, 2));
		
		createColleague();
		
		ButtonGroup group=new ButtonGroup();
		group.add(guestRadio);group.add(userRadio);
		add(guestRadio);add(userRadio);
		add(new JLabel("user name:"));add(name);
		add(new JLabel("password:"));add(pwd);
		add(login);add(cancle);
		
		colleagueChanged();
		
		setBounds(400, 400, 400, 300);
		setVisible(true);
	}
	
	
	

	@Override
	public void createColleague() {
		guestRadio=new ColleagueRadioButton("guest", true);
		userRadio=new ColleagueRadioButton("user", false);
		name=new ColleagueTextFiled("");
		pwd=new ColleagueTextFiled("");
		login=new ColleagueButton("login");
		cancle=new ColleagueButton("cancle");
		
		guestRadio.setMediator(this);
		userRadio.setMediator(this);
		name.setMediator(this);
		pwd.setMediator(this);
		login.setMediator(this);
		cancle.setMediator(this);
		
		guestRadio.addItemListener(guestRadio);
		userRadio.addItemListener(userRadio);
		name.getDocument().addDocumentListener(name);
		pwd.getDocument().addDocumentListener(pwd);
		login.addActionListener(this);
		cancle.addActionListener(this);
		
	}
	
	private void pwdChanged(){
		if(name.getText().length()>0){
			pwd.setColleagueEnabled(true);
			if(pwd.getText().length()>0)
				login.setColleagueEnabled(true);
			else
				login.setColleagueEnabled(false);
		}else {
			pwd.setColleagueEnabled(false);
			login.setColleagueEnabled(false);
		}
	}

	@Override
	public void colleagueChanged() {
		if(guestRadio.isSelected()){
			name.setColleagueEnabled(false);
			pwd.setColleagueEnabled(false);
			login.setColleagueEnabled(true);
		}else{
			name.setColleagueEnabled(true);
			pwdChanged();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.exit(0);
	}

}
