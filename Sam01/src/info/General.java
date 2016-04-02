package info;

import cmn.GradeExtra;
import cmn.GradeMain;

public class General //Character 
{
	private String name;			// �����
	private GradeMain battleMain;			// ���������
	private GradeExtra battleExtra;			// ���������
	private GradeMain tacticsMain;		// ���������
	private GradeExtra tacticsExtra;		// ���������
	private GradeMain leadershipMain;		// ����ֵ��
	private GradeExtra leadershipExtra;		// ����ֵ��
	private GradeMain management;		// ����

	public General()
	{
		name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GradeMain getBattleMain() {
		return battleMain;
	}
	
	public GradeExtra getBattleExtra() {
		return battleExtra;
	}

	public void setBattleMain(GradeMain battleMain) {
		this.battleMain = battleMain;
	}
	
	public void setBattleExtra(GradeExtra battleExtra) {
		this.battleExtra = battleExtra;
	}

	public GradeMain getTacticsMain() {
		return tacticsMain;
	}
	
	public GradeExtra getTacticsExtra() {
		return tacticsExtra;
	}

	public void setTacticsMain(GradeMain tacticsMain) {
		this.tacticsMain = tacticsMain;
	}
	
	public void setTacticsExtra(GradeExtra tacticsExtra) {
		this.tacticsExtra = tacticsExtra;
	}

	public GradeMain getManagement() {
		return management;
	}

	public void setManagement(GradeMain management) {
		this.management = management;
	}

	public GradeMain getLeadershipMain() {
		return leadershipMain;
	}

	public void setLeadershipMain(GradeMain leadershipMain) {
		this.leadershipMain = leadershipMain;
	}

	public GradeExtra getLeadershipExtra() {
		return leadershipExtra;
	}

	public void setLeadershipExtra(GradeExtra leadershipExtra) {
		this.leadershipExtra = leadershipExtra;
	}
	
	
}
