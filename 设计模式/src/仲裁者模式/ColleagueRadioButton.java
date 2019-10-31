package 仲裁者模式;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

public class ColleagueRadioButton extends JRadioButton implements Colleague,ItemListener{
	private static final long serialVersionUID = 1L;
	
	private Mediator mediator;
	
	public ColleagueRadioButton(String msg,boolean state) {
		super(msg, state);//组件最初可用不可用
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator=mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);//启用或者禁用按钮
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged();//组件产生变化，交由mediator处理
	}

}
