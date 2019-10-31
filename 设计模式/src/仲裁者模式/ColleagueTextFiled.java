package �ٲ���ģʽ;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ColleagueTextFiled extends JTextField implements Colleague,DocumentListener{
	private static final long serialVersionUID = 1L;
	
	private Mediator mediator;
	
	public ColleagueTextFiled(String msg) {
		super(msg);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator=mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled?Color.white:Color.lightGray);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		mediator.colleagueChanged();//��������仯������mediator����
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		mediator.colleagueChanged();//��������仯������mediator����
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		mediator.colleagueChanged();//��������仯������mediator����
	}

}
