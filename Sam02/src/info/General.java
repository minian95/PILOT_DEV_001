package info;

import cmn.Grade;

public class General //Character 
{
	private String name;			// �����
	private Grade battlePower;			// �����µ��
	private Grade tacticPower;		// �����µ��
	private Grade leadership;		// ��ַµ��
	private Grade management;		// �����µ��

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
