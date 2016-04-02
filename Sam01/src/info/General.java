package info;

import cmn.GradeExtra;
import cmn.GradeMain;

public class General //Character 
{
	private String name;			// 장수명
	private GradeMain battleMain;			// 주전투등급
	private GradeExtra battleExtra;			// 부전투등급
	private GradeMain tacticsMain;		// 주전술등급
	private GradeExtra tacticsExtra;		// 부전술등급
	private GradeMain leadershipMain;		// 주통솔등급
	private GradeExtra leadershipExtra;		// 부통솔등급
	private GradeMain management;		// 내정

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
