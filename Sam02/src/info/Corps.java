package info;

import java.util.List;

// 군단,부대
public class Corps 
{
	// 부대 구성 장수
	private General commander; // 지휘관
	private List<General> adviser; // 참모
	private List<General> adjutantList; // 부대장목록
	
	private CombatUnit cavalry; // 기병
	private CombatUnit infantry; // 보병
	private CombatUnit archer; // 궁병
	
	public Corps()
	{
	
	}
}
