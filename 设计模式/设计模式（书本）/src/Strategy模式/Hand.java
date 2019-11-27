package Strategyģʽ;

public enum Hand {
	ShiTou("ʯͷ",0),JianDao("����",1),Bu("��",2);
	
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
			return 0;//ƽ��
		if((this.value+1)%3==hand.value)
			return 1;//��Ӯ
		return -1;//��Ӯ
	}
	
	public boolean isStrongerThan(Hand hand){//Ӯ
		return fight(hand)==1;
	}
	
	public boolean isWeakerThan(Hand hand){//��
		return fight(hand)==-1;
	}
	
	public boolean isDraw(Hand hand){//ƽ
		return fight(hand)==0;
	}
	
}
