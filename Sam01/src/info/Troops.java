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
	private int cavarlryman;	// �⺴
	private int infantryman;	// ����
	private int spearman;		// â��
	private int bowman;			// Ȱ��
	
	// �δ� �Ӽ�
	private int speed;			// �ӵ�
	private int battle;			// ������
	private int defense;		// ����
	private int morale;			// ���
	private int confusionRate;		// ȥ������(%)
								// ����ɷ�(����)
	

	private int landform;	// ����
	
	public Troops()
	{
		commander = null;
		adviser = null;
		adjutantList = null;
		
		cavarlryman = 0;
		spearman = 0;
		bowman = 0;
		
		speed = 0;
		battle = 0;
		defense = 0;
		morale = 0;
		confusionRate = 0;
	}
	
	public void beAttacked(int enermyBattlePower)
	{
		int killedTtoop = (int)Math.round((double)enermyBattlePower/10000);
		
		cavarlryman = cavarlryman - killedTtoop;
	}
	
	public void addConfusionRate(Troops enemyTroops)
	{
		// todo ������ ���������� ȥ���� ���� ����
		
		int enemyCommanderBattlePower = GradeManager.getPowerValue(enemyTroops.getCommander());
		int commanderBattlePower = GradeManager.getPowerValue(this.getCommander());
		
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
		
		if ((confusionRate+addRate) > 50)
			confusionRate = 50;
		else
			confusionRate = confusionRate + addRate;
		
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
	
	public int getCavarlyPower()
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
		int possibleCavarlryman = cavarlryman - (int)Math.round((double)cavarlryman*confusionRate/100);
		power = possibleCavarlryman * GradeManager.getPowerValue(commander);

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

	public int getCavarlryman() {
		return cavarlryman;
	}

	public void setCavarlryman(int cavarlryman) {
		this.cavarlryman = cavarlryman;
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
	
	public int getConfusionRate() {
		return confusionRate;
	}

	public void setConfusionRate(int confusionRate) {
		this.confusionRate = confusionRate;
	}
}
