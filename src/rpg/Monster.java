package rpg;

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

	@Override
	public void specialEvilAttack(Human target){
		String name = super.getName();
		System.out.println( name  + " のとくしゅこうげき！");
		System.out.println("しかし" +  name + "は失敗してしまった！ ");
	}

}
