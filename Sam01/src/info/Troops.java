package info;

import java.util.List;

import cmn.GradeManager;
import cmn.TroopsType;

public class Troops // battle unit 
{
	// 부대 구성 장수
	private General commander; // 부대장
	private General adviser; // 참모
	private List<General> adjutantList; // 부관목록
	
	// 구성 병과 병사수
	private int cavalrymen;		// 기병
	private int infantrymen;	// 보병
	private int spearmen;		// 창병
	private int bowmen;			// 활병
	
	// 부대 속성
	private int speed;			// 속도
	private int battle;			// 전투력
	private int defense;		// 방어력
	private int morale;			// 사기(%)
	private int confusion;		// 혼란(%)
	private int fatigability;	// 피로도(%)
	private int capacity;		// 부대 전력,수행능력(역량)
	

	private int landform;	// 지형
	
	public Troops()
	{
		commander = null;
		adviser = null;
		adjutantList = null;
		
		cavalrymen = 0;
		spearmen = 0;
		bowmen = 0;
		
		speed = 0;
		battle = 0;
		defense = 0;
		morale = 0;
		confusion = 0;
	}
	
	public void beAttacked(int enermyBattlePower)
	{
		int killedTtoop = (int)Math.round((double)enermyBattlePower/10000);
		
		cavalrymen = cavalrymen - killedTtoop;
	}
	
	public void addConfusion(Troops enemyTroops)
	{
		// todo 참모의 전술력으로 혼란도 비율 감쇄
		
		int enemyCommanderBattlePower = GradeManager.getPower(enemyTroops.getCommander());
		int commanderBattlePower = GradeManager.getPower(this.getCommander());
		
		// 부대장 전투력 비교 및 혼란도 적용
		// 부대장 전투력 비교 후 그 비율만큼 전투력이 적은 부대의 혼란도 증가
		int addRate = 0;
		if (commanderBattlePower < enemyCommanderBattlePower)
		{
			addRate = (int)Math.round((enemyCommanderBattlePower-commanderBattlePower)/10);
			//System.out.println("C:"+commanderBattlePower+", e:"+enemyCommanderBattlePower
			//		+", addRate:"+addRate);
		}
		
		// todo 혼란도는 최대값 까지만 증가(최대값은 통솔력으로 결정)
		
		if ((confusion+addRate) > 50)
			confusion = 50;
		else
			confusion = confusion + addRate;
		
		return;
	}
	
	public void process() // 1틱 진행
	{
		// 혼란도가 통솔력에 비해 기준이하면
		// 	- 혼란도 증가
		// 혼란도가 통솔력에 비해 기준이상이면
		// 	- 혼란도 감소
		
		// 상황에 따라 부대 이동 또는 전투
		// 그외 상황 진행
	}
	
	public void move()
	{
		// 사기는 조금씩 감소(통솔력에 따라 감소치 다름)
		// 기타 이동에 따른 다른 상황 진행
	}
	
	// 전투 가능 병사수
	public int getMenNumberCanBattle(TroopsType troopsType)
	{
		int menNumber = 0;
		
		switch(troopsType)
		{
			case BOW:
				menNumber = bowmen;
				break;
			case CAVALY:
				menNumber = cavalrymen;
				break;
			case INFANTRY:
				menNumber = infantrymen;
				break;
			default:
				menNumber = 0;
				break;
		}
		
		// todo : 통솔력을 오버하는 병력수 제외
		
		// 혼란도에 비례해서 병사수 감소
		menNumber = menNumber - (int)Math.round((double)menNumber*confusion/100);
		
		return menNumber;
	}
	
	// 전투력 
	public int getCavalyPower()
	{
		// 장수 전투력, 가용 병사수, 사기
		// 전투참여 병사수 : 혼란도 만큼 제외
		// 통솔력 이상의 병사는 처음부터 제외
		// 혼란도
		//	- 통솔력으로 회복됨
		//	- 최초 0, 1틱 때마다 통솔력에 반비례 증가, 최대치는 통솔력에 반비례
		//	- 전투시 상대 부대 전술력, 전투력에 영향받음
		//	- 성에 주둔시 다시 회복
		// 사기
		//	- 전투시 승리할때마다 증가하고 전투없으면 감소
		//	- 최초 0
		// 지형
		//	- 병과별로 영향받는 지형이 다름
		// 전술 차이이 따라 전투력 이 최하로 나올수 있음
		
		//-----------------------------------------
		
		// 전투 가능 병사수
		int cavalrymen = getMenNumberCanBattle(TroopsType.CAVALY);
		
		// 부대 기본전투력:병력수*병과전투력
		
		// 사기 적용:장수 전투력 차이에 비례
		// 피로도
		// 지형
		// 장수 전투력 
		
		int power = 0;
		
		power = cavalrymen * GradeManager.getPower(commander);

		return power;
	}
	
	public General getCommander() {
		return commander;
	}

	public void setCommander(General commander) {
		this.commander = commander;
	}

	public General getAdviser() {
		return adviser;
	}

	public void setAdviser(General adviser) {
		this.adviser = adviser;
	}

	public int getCavalrymen() {
		return cavalrymen;
	}

	public void setCavalrymen(int cavalrymen) {
		this.cavalrymen = cavalrymen;
	}

	public int getSpearmen() {
		return spearmen;
	}

	public void setSpearmen(int spearmen) {
		this.spearmen = spearmen;
	}

	public int getBowmen() {
		return bowmen;
	}

	public void setBowmen(int bowmen) {
		this.bowmen = bowmen;
	}
	
	public int getConfusion() {
		return confusion;
	}

	public void setConfusion(int confusion) {
		this.confusion = confusion;
	}
}
