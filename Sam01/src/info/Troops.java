package info;

import java.util.List;

import cmn.GradeManager;

public class Troops // battle unit 
{
	// 부대 구성 장수
	private General commander; // 부대장
	private General adviser; // 참모
	private List<General> adjutantList; // 부관목록
	
	// 구성 병과 병사수
	private int cavalryman;		// 기병
	private int infantryman;	// 보병
	private int spearman;		// 창병
	private int bowman;			// 활병
	
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
		
		cavalryman = 0;
		spearman = 0;
		bowman = 0;
		
		speed = 0;
		battle = 0;
		defense = 0;
		morale = 0;
		confusion = 0;
	}
	
	public void beAttacked(int enermyBattlePower)
	{
		int killedTtoop = (int)Math.round((double)enermyBattlePower/10000);
		
		cavalryman = cavalryman - killedTtoop;
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
		
		
		int power = 0;
		int possibleCavalryman = cavalryman - (int)Math.round((double)cavalryman*confusion/100);
		power = possibleCavalryman * GradeManager.getPower(commander);

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

	public int getCavalryman() {
		return cavalryman;
	}

	public void setCavalryman(int cavalryman) {
		this.cavalryman = cavalryman;
	}

	public int getSpearman() {
		return spearman;
	}

	public void setSpearman(int spearman) {
		this.spearman = spearman;
	}

	public int getBowman() {
		return bowman;
	}

	public void setBowman(int bowman) {
		this.bowman = bowman;
	}
	
	public int getConfusion() {
		return confusion;
	}

	public void setConfusion(int confusion) {
		this.confusion = confusion;
	}
}
