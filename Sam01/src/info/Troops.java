package info;

import java.util.List;

import cmn.GradeManager;
import cmn.TroopsType;

public class Troops // battle unit 
{
	// ������ ����� �⺻ ������
	public static int CAVALY_MEN_POWER = 10;
	public static int INFANTRY_MEN_POWER = 2;
	public static int BOW_MEN_POWER = 1;
	
	public static int DEATH_PER_POWER = 500; // ���ݷ´� �������
	
	// �δ� ���� ���
	private General commander; // �δ���
	private General adviser; // ����
	private List<General> adjutantList; // �ΰ����
	
	// ���� ���� �����
	private int cavalrymen;		// �⺴
	private int infantrymen;	// ����
	private int spearmen;		// â��
	private int bowmen;			// Ȱ��
	
	// �δ� �Ӽ�
	private int speed;			// �ӵ�
	private int battle;			// ������
	private int defense;		// ����
	private int morale;			// ���(%)
	private int confusion;		// ȥ��(%)
	private int fatigability;	// �Ƿε�(%), �ൿ��
	private int capacity;		// �δ� ����,����ɷ�(����)

	private int landform;	// ����
	
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
		// todo ������ ���������� ȥ���� ���� ����
		
		int enemyCommanderBattlePower = GradeManager.getPower(enemyTroops.getCommander());
		int commanderBattlePower = GradeManager.getPower(this.getCommander());
		
		// �δ��� ������ �� �� ȥ���� ����
		// �δ��� ������ �� �� �� ������ŭ �������� ���� �δ��� ȥ���� ����
		int addRate = 0;
		if (commanderBattlePower < enemyCommanderBattlePower)
		{
			addRate = (int)Math.round((enemyCommanderBattlePower-commanderBattlePower)/10);
			//System.out.println("C:"+commanderBattlePower+", e:"+enemyCommanderBattlePower
			//		+", addRate:"+addRate);
		}
		
//		if (addRate == 0)
//		{
//			addRate = 1;	// �߰� ȥ������ 0 �̸� �⺻�� ����
//		}
		
		if ((confusion+addRate) > 50)
			confusion = 50;
		else
			confusion = confusion + addRate;
		
		//System.out.println(commander.getName() + " : con=" + confusion); 
		
		return;
	}
	
	public void process() // 1ƽ ����
	{

	}
	
	public void move()
	{

	}
	
	// ���� ���� �����
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
		
		// todo : ��ַ��� �����ϴ� ���¼� ����
		
		// ȥ������ ����ؼ� ����� ����
		menNumber = menNumber - (int)Math.round((double)menNumber*confusion/100);
		
		return menNumber;
	}
	
	// ������ 
	public int getCavalyPower(Troops enemyTroops)
	{
		// ���� ���� �����
		int cavalrymen = getMenNumberCanBattle(TroopsType.CAVALY);
		
		// �δ� �⺻������:���¼�*�����⺻������
		int troopsBasePower = cavalrymen*CAVALY_MEN_POWER;
		
		// ��� ����
		
		// �Ƿε�
		// ����
		// ��� ������ 
		
		int generalPower = GradeManager.getPower(commander);
		int enemyGeneralPower = GradeManager.getPower(enemyTroops.getCommander());
		
		int totalPower = troopsBasePower + generalPower;
		
		// ��� ������ ���� ����
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
