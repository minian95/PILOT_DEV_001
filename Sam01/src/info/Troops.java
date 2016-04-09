package info;

import java.util.List;

import cmn.GradeManager;
import cmn.TroopsType;

public class Troops // battle unit 
{
	// 병과별 병사당 기본 전투력
	public static int CAVALY_MEN_POWER = 10;
	public static int INFANTRY_MEN_POWER = 2;
	public static int BOW_MEN_POWER = 1;
	
	public static int DEATH_PER_POWER = 500; // 공격력당 사망비율
	
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
	private int fatigability;	// 피로도(%), 행동력
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
		int DeathMen = (int)Math.round((double)enermyBattlePower/DEATH_PER_POWER);
		
		cavalrymen = cavalrymen - DeathMen;
	}
	
	public void applyConfusion(Troops enemyTroops)
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
		
//		if (addRate == 0)
//		{
//			addRate = 1;	// 추가 혼란도가 0 이면 기본값 적용
//		}
		
		if ((confusion+addRate) > 50)
			confusion = 50;
		else
			confusion = confusion + addRate;
		
		//System.out.println(commander.getName() + " : con=" + confusion); 
		
		return;
	}
	
	public void process() // 1틱 진행
	{

	}
	
	public void move()
	{

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
	public int getCavalyPower(Troops enemyTroops)
	{
		// 전투 가능 병사수
		int cavalrymen = getMenNumberCanBattle(TroopsType.CAVALY);
		
		// 부대 기본전투력:병력수*병과기본전투력
		int troopsBasePower = cavalrymen*CAVALY_MEN_POWER;
		
		// 사기 적용
		
		// 피로도
		// 지형
		// 장수 전투력 
		
		int generalPower = GradeManager.getPower(commander);
		int enemyGeneralPower = GradeManager.getPower(enemyTroops.getCommander());
		
		int totalPower = troopsBasePower + generalPower;
		
		// 장수 전투력 차이 적용
		double temp = 0;
		if (generalPower > enemyGeneralPower)
		{
			temp = (1 - (double)enemyGeneralPower/generalPower);
		}
//		else
//		{
//			temp = -(1 - (double)generalPower/enemyGeneralPower);
//		}
		
		totalPower = totalPower + (int)(totalPower*temp);
		//System.out.println("temp:" + temp + ", totalPower:" + totalPower + ", totalPower2:" + totalPower*temp);
		//System.out.println("cavalrymen:" + cavalrymen + ", troopsBasePower:" + troopsBasePower +", generalPower:" + generalPower);

		return totalPower;
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
