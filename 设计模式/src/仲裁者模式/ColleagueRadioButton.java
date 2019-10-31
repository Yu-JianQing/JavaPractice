package �ٲ���ģʽ;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

public class ColleagueRadioButton extends JRadioButton implements Colleague,ItemListener{
	private static final long serialVersionUID = 1L;
	
	private Mediator mediator;
	
	public ColleagueRadioButton(String msg,boolean state) {
		super(msg, state);//���������ò�����
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator=mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);//���û��߽��ð�ť
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged();//��������仯������mediator����
	}

}
