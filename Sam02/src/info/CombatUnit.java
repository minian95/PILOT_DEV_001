package info;

import cmn.LandformType;
import cmn.UnitType;

public class CombatUnit {

	private UnitType type;	// 병과
	private int number; // 병력수
	private int diable;		// 전투불능 병력수
	
	private CombatPower combatPower; // 전투력
	private int actingPower;	// 행동력
	private int confusion;	// 혼란도
	
	// todo : 지휘관 통솔력 초과 병력 제외하는 로직
	
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
		
		// 전투불능 병력수 제외
		result = number - diable;
		
		// 혼란도에 비례해서 병사수 감소
		result = result - (int)Math.round((double)result*confusion/100);
		
		return result;
	}
}
