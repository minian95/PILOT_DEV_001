package info;

import cmn.LandformType;
import cmn.UnitType;

public class CombatUnit {

	private UnitType type;	// ����
	private int number; // ���¼�
	private int diable;		// �����Ҵ� ���¼�
	
	private CombatPower combatPower; // ������
	private int actingPower;	// �ൿ��
	private int confusion;	// ȥ����
	
	// todo : ���ְ� ��ַ� �ʰ� ���� �����ϴ� ����
	
	public CombatUnit(UnitType type)
	{
		this.type = type;
		
		confusion = 0;
		actingPower = 0;
		diable = 0;
	}
	
	public int getAttackPower(LandformType landformType)
	{
		return getPossibleNumber() * combatPower.getAttcakPower(type, landformType);
	}
	
	public int getDefencePower(LandformType landformType)
	{
		return getPossibleNumber() * combatPower.getDefencePower(type, landformType);
	}
	
	public void addCofusion(int rate)
	{
		confusion = confusion + rate;
	}
	
	public void addDiable(int num)
	{
		if (num > number)
			num = number;
		
		diable = diable + num;
	}
	
	public int getPossibleNumber()
	{
		int result = 0;
		
		// �����Ҵ� ���¼� ����
		result = number - diable;
		
		// ȥ������ ����ؼ� ����� ����
		result = result - (int)Math.round((double)result*confusion/100);
		
		return result;
	}
}
