package main;

public class Monster extends Human{
	//コンストラクタ
	public Monster(){
		super.setName("モンスター");
		super.setGender(1);
		super.setLength(710);
		super.setWeight(1200);
		super.setVitality(100);
		super.setMagic(0);
	}


	public void specialEvilAttack(Human target){
		String name = super.getName();
		System.out.println( name  + " の こうげき");
		System.out.println( name + " の じゃあくな ひっさつわざが さくれつした！");

		target.setVitality(target.getVitality() - 30);
		System.out.println( target.getName() + " は 30 のダメージをうけた");

		super.setVitality(super.getVitality() - 10);
		System.out.println( name + " の たいりょくは" + super.getVitality() + "になった");
		System.out.println("");
	}

}
