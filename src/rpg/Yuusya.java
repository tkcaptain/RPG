package rpg;

public class Yuusya extends Human {

	//コンストラクタ
	public Yuusya(){
		super.setName("ゆうしゃ");
		super.setGender(1);
		super.setLength(180);
		super.setWeight(70);
		super.setVitality(100);
		super.setMagic(50);
	}

	public void specialAttack(Human target){
		String name = super.getName();
		System.out.println( name  + " の こうげき");
		System.out.println( name + " あばんすとらっしゅ！");

		target.setVitality(target.getVitality() - 50);
		System.out.println( target.getName() + " に 50 のダメージを あたえた");

		super.setMagic(super.getMagic() - 10);
		System.out.println( name + " の まりょくは " + super.getMagic() + " になった");
		System.out.println("");
	}
}
