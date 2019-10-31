package Strategy模式;

public enum Hand {
	ShiTou("石头",0),JianDao("剪刀",1),Bu("布",2);
	
	private String name;
	private int value;
	
	private Hand(String name,int value){
		this.name=name;
		this.value=value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	private int fight(Hand hand){
		if(this.value==hand.value)
			return 0;//平手
		if((this.value+1)%3==hand.value)
			return 1;//我赢
		return -1;//他赢
	}
	
	public boolean isStrongerThan(Hand hand){//赢
		return fight(hand)==1;
	}
	
	public boolean isWeakerThan(Hand hand){//输
		return fight(hand)==-1;
	}
	
	public boolean isDraw(Hand hand){//平
		return fight(hand)==0;
	}
	
}
