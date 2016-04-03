package info;

import java.util.List;

import cmn.GradeManager;
import cmn.TroopsType;

public class Troops // battle unit 
{
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
	private int fatigability;	// �Ƿε�(%)
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
		int killedTtoop = (int)Math.round((double)enermyBattlePower/10000);
		
		cavalrymen = cavalrymen - killedTtoop;
	}
	
	public void addConfusion(Troops enemyTroops)
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
		
		// todo ȥ������ �ִ밪 ������ ����(�ִ밪�� ��ַ����� ����)
		
		if ((confusion+addRate) > 50)
			confusion = 50;
		else
			confusion = confusion + addRate;
		
		return;
	}
	
	public void process() // 1ƽ ����
	{
		// ȥ������ ��ַ¿� ���� �������ϸ�
		// 	- ȥ���� ����
		// ȥ������ ��ַ¿� ���� �����̻��̸�
		// 	- ȥ���� ����
		
		// ��Ȳ�� ���� �δ� �̵� �Ǵ� ����
		// �׿� ��Ȳ ����
	}
	
	public void move()
	{
		// ���� ���ݾ� ����(��ַ¿� ���� ����ġ �ٸ�)
		// ��Ÿ �̵��� ���� �ٸ� ��Ȳ ����
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
	public int getCavalyPower()
	{
		// ��� ������, ���� �����, ���
		// �������� ����� : ȥ���� ��ŭ ����
		// ��ַ� �̻��� ����� ó������ ����
		// ȥ����
		//	- ��ַ����� ȸ����
		//	- ���� 0, 1ƽ ������ ��ַ¿� �ݺ�� ����, �ִ�ġ�� ��ַ¿� �ݺ��
		//	- ������ ��� �δ� ������, �����¿� �������
		//	- ���� �ֵн� �ٽ� ȸ��
		// ���
		//	- ������ �¸��Ҷ����� �����ϰ� ���������� ����
		//	- ���� 0
		// ����
		//	- �������� ����޴� ������ �ٸ�
		// ���� ������ ���� ������ �� ���Ϸ� ���ü� ����
		
		//-----------------------------------------
		
		// ���� ���� �����
		int cavalrymen = getMenNumberCanBattle(TroopsType.CAVALY);
		
		// �δ� �⺻������:���¼�*����������
		
		// ��� ����:��� ������ ���̿� ���
		// �Ƿε�
		// ����
		// ��� ������ 
		
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
