package rpg;

public class LastBoss extends Human{
	//コンストラクタ
	public LastBoss(){
		super.setName("らすぼす");
		super.setGender(1);
		super.setLength(210);
		super.setWeight(120);
		super.setVitality(500);
		super.setMagic(40);
	}


	public void specialEvilAttack(Human target){
		String name = super.getName();
		System.out.println( name  + " の 特殊攻撃！");
		System.out.println( name + " ちょうまばくえんは！！");

		target.setVitality(target.getVitality() - 50);
		System.out.println( target.getName() + " は 50 のダメージをうけた");
	}

}
