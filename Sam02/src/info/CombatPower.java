package info;

import cmn.LandformType;
import cmn.UnitType;

public class CombatPower {
	// todo : 성을 공격할때, 성에서 공격할때 공격력을 구분할지 검토
	
	private static int CAVALRY_ATTACK_FLATLAND = 20;
	private static int CAVALRY_ATTACK_CASTLE = 0;
	private static int CAVALRY_ATTACK_FOREST = 0;
	
	private static int CAVALRY_DEFENCE_FLATLAND = 7;
	private static int CAVALRY_DEFENCE_CASTLE = 0;
	private static int CAVALRY_DEFENCE_FOREST = 0;
	
	private static int INFANTRY_ATTACK_FLATLAND = 3;
	private static int INFANTRY_ATTACK_CASTLE = 3;
	private static int INFANTRY_ATTACK_FOREST = 3;
	
	private static int INFANTRY_DEFENCE_FLATLAND = 7;
	private static int INFANTRY_DEFENCE_CASTLE = 3;
	private static int INFANTRY_DEFENCE_FOREST = 3;
	
	private static int ARCHER_ATTACK_FLATLAND = 5;
	private static int ARCHER_ATTACK_CASTLE = 7;
	private static int ARCHER_ATTACK_FOREST = 2;
	
	private static int ARCHER_DEFENCE_FLATLAND = 1;
	private static int ARCHER_DEFENCE_CASTLE = 3;
	private static int ARCHER_DEFENCE_FOREST = 2;
	
	public int getAttcakPower(UnitType unitType, LandformType landformType)
	{
		int power = 0;
		switch(unitType)
		{
			case CAVALRY:
				switch(landformType)
				{
					case FLATLAND:
						power = CAVALRY_ATTACK_FLATLAND;
						break;
					case CASTLE:
						power = CAVALRY_ATTACK_CASTLE;
						break;
					case FOREST:
						power = CAVALRY_ATTACK_FOREST;
						break;
					default:
						power = 0;
						break;
				}
			default:
				power = 0;
				break;
		}
		return power;
	}
	
	public int getDefencePower(UnitType unitType, LandformType landformType)
	{
		int power = 0;
		switch(unitType)
		{
			case CAVALRY:
				switch(landformType)
				{
					case FLATLAND:
						power = CAVALRY_DEFENCE_FLATLAND;
						break;
					case CASTLE:
						power = CAVALRY_DEFENCE_CASTLE;
						break;
					case FOREST:
						power = CAVALRY_DEFENCE_FOREST;
						break;
					default:
						power = 0;
						break;
				}
			default:
				power = 0;
				break;
		}
		
		return power;
	}
}
