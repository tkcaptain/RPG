package Item;

import rpg.Human;

public class Item {

	private String name = null; //なまえ
	protected int effect = 0;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}


	public void huse(Human target){
		String name = this.name;
		System.out.println(name  + "を使った！");
		target.setVitality(target.getVitality() + effect);
		System.out.println( target.getName() + " は  "  + effect + "回復した");
		System.out.println("");
	}

	public void duse(Human target){
		String name = this.name;
		System.out.println(name  + "を使った！");
		target.setVitality(target.getVitality() - effect);
		System.out.println( target.getName() + " に  "  + effect + "のダメージ！");
		System.out.println("");
	}



}
