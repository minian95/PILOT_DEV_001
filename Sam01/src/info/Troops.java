package info;

import java.util.List;

import cmn.GradeManager;

public class Troops // battle unit 
{
	// �δ� ���� ���
	private General commander; // �δ���
	private General adviser; // ����
	private List<General> adjutantList; // �ΰ����
	
	// ���� ���� �����
	private int cavalryman;		// �⺴
	private int infantryman;	// ����
	private int spearman;		// â��
	private int bowman;			// Ȱ��
	
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
