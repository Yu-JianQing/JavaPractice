package Stateģʽ;

public class DayState extends State{
	private static DayState dayState=new DayState();
	
	private DayState(){}
	
	public static DayState getInstance(){
		return dayState;
	}

	@Override
	public void doClock(Context context,int hour) {
		if(hour<9||hour>17)
			context.changeState(NightState.getInstance());
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("use money in day");
	}

	@Override
	public void doAlarm(Context context) {
		context.dealCall("push the alarm in day");
	}

	@Override
	public void doPhone(Context context) {
		context.dealCall("talk with phone in day");
	}
	
	public String toString(){
		return "it's day";
	}

}
