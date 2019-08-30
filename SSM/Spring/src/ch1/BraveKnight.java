package ch1;

public class BraveKnight implements Knight{
	private Quest quest;//将quest注入进来
	
	public BraveKnight(Quest quest){//构造器注入法，普通装配
		this.quest=quest;
	}
	
	public void embarkQuest() {
		quest.embark();
	}
	
}
