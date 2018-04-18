package rpg;

public class Wizard extends Human {

	//コンストラクタ
	public Wizard(){
		super.setName("まほうつかい");
		super.setGender(1);
		super.setLength(170);
		super.setWeight(60);
		super.setVitality(50);
		super.setMagic(50);
	}

	public void specialAttack(Human target){
		String name = super.getName();
		System.out.println( name  + " の 魔法攻撃！");
		System.out.println( name + " メラゾーマ！！");

		target.setVitality(target.getVitality() - 40);
		System.out.println( target.getName() + " に 40 のダメージを あたえた");

		super.setMagic(super.getMagic() - 15);
		System.out.println( name + " の まりょくは " + super.getMagic() + " になった");
		System.out.println("");
	}

}