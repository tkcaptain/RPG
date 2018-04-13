package main;

public class Cleric extends Human {
	//コンストラクタ
	public Cleric(){
		super.setName("そうりょ");
		super.setGender(2);
		super.setLength(160);
		super.setWeight(50);
		super.setVitality(20);
		super.setMagic(70);
	}

	//かいふくじゅもん
	public void healingMagic(Human target){
		String name = super.getName();
		System.out.println( name + " は かいふくじゅもんをとなえた！");

		target.setVitality(target.getVitality() + 20);
		System.out.println( target.getName() + " の たいりょくは " + target.getVitality() + "　になった");

		target.setMagic(super.getMagic() - 10);
		System.out.println( name + " の まりょくは " + super.getMagic()+ "　になった");
		System.out.println("");
	}

}
