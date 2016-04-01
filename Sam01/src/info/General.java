package info;

import cmn.Grade;

public class General //Character 
{
	private String name;			// �����
	private Grade battleMain;			// ��������
	private Grade battleExtra;			// ��������
	private Grade tacticsMain;		// ��������
	private Grade tacticsExtra;		// ��������
	private Grade leadership;		// ��ַ�
	private Grade management;		// ����

	public General()
	{
		name = "";
		battleMain = null;
		battleExtra = null;
		tacticsMain = null;
		tacticsExtra = null;
		leadership = null;
		management = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getBattleMain() {
		return battleMain;
	}
	
	public Grade getBattleExtra() {
		return battleExtra;
	}

	public void setBattleMain(Grade battleMain) {
		this.battleMain = battleMain;
	}
	
	public void setBattleExtra(Grade battleExtra) {
		this.battleExtra = battleExtra;
	}

	public Grade getTacticsMain() {
		return tacticsMain;
	}
	
	public Grade getTacticsExtra() {
		return tacticsExtra;
	}

	public void setTacticsMain(Grade tacticsMain) {
		this.tacticsMain = tacticsMain;
	}
	
	public void setTacticsExtra(Grade tacticsExtra) {
		this.tacticsExtra = tacticsExtra;
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
