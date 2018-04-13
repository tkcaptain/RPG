package main;

public class Yuusya extends Human {

	//コンストラクタ
	public Yuusya(){
		super.setName("ゆうしゃ");
		super.setGender(1);
		super.setLength(180);
		super.setWeight(70);
		super.setVitality(100);
		super.setMagic(5);
	}

	public void specialAttack(Human target){
		String name = super.getName();
		super.setVitality(super.getVitality() - 20);
		System.out.println( name  + " の こうげき");
		System.out.println( name + " の ひっさつわざが さくれつした！");

		target.setVitality(target.getVitality() - 50);
		System.out.println( target.getName() + " に 50 のダメージを あたえた");

		super.setVitality(super.getVitality() - 10);
		System.out.println( name + " の たいりょくは" + super.getVitality() + "になった");
		System.out.println("");
	}
}
