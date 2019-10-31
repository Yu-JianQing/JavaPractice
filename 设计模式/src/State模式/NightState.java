package Stateģʽ;

public class NightState extends State{
	private static NightState night=new NightState();
	
	private NightState(){}
	
	public static NightState getInstance(){
		return night;
	}

	@Override
	public void doClock(Context context,int hour) {
		if(hour>9&&hour<17)
			context.changeState(DayState.getInstance());
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("use money in night!!!");
	}

	@Override
	public void doAlarm(Context context) {
		context.dealCall("push the alarm in night!!!");
	}

	@Override
	public void doPhone(Context context) {
		context.dealCall("talk with phone in night!!!");
	}
	
	public String toString(){
		return "it's night";
	}

}
