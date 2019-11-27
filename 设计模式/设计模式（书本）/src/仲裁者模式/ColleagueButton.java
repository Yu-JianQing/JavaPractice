package 仲裁者模式;

import javax.swing.JButton;

public class ColleagueButton extends JButton implements Colleague{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private Mediator mediator;
	
	public ColleagueButton(String msg) {
		super(msg);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator=mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);//启用或者禁用按钮
	}

}
