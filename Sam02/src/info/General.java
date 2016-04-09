package info;

import cmn.Grade;

public class General //Character 
{
	private String name;			// 장수명
	private Grade battlePower;			// 전투력등급
	private Grade tacticPower;		// 전술력등급
	private Grade leadership;		// 통솔력등급
	private Grade management;		// 내정력등급

	public General()
	{
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getBattlePower() {
		return battlePower;
	}

	public void setBattlePower(Grade battlePower) {
		this.battlePower = battlePower;
	}

	public Grade getTacticPower() {
		return tacticPower;
	}

	public void setTacticPower(Grade tacticPower) {
		this.tacticPower = tacticPower;
	}

	public Grade getLeadership() {
		return leadership;
	}

	public void setLeadership(Grade leadership) {
		this.leadership = leadership;
	}

	public Grade getManagement() {
		return management;
	}

	public void setManagement(Grade management) {
		this.management = management;
	}
	
	
}
