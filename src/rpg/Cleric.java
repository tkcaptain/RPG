package rpg;

public class Cleric extends Human {
	//コンストラクタ
	public Cleric(){
		super.setName("そうりょ");
		super.setGender(2);
		super.setLength(160);
		super.setWeight(50);
		super.setVitality(60);
		super.setMagic(70);
	}

	//かいふくじゅもん
	public void specialAttack(Human target){
		String name = super.getName();
		System.out.println( name + " は ホイミをとなえた！");

		target.setVitality(target.getVitality() + 40);
		System.out.println( target.getName() + " の たいりょくは " + target.getVitality() + "　になった");

		super.setMagic(super.getMagic() - 10);
		System.out.println( name + " の まりょくは " + super.getMagic()+ "　になった");
		System.out.println("");
	}

}
