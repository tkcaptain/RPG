 package main;

import java.util.Random;

public class Human {

	private String name = null; //なまえ
	private int gender = 0; 	//性別(1:男　2:女)
	private int length = 0;		//身長
	private int weight = 0;		//体重
	private int vitality = 0;	//たいりょく
	private int magic = 0;		//まりょく
	Random rand = new Random();

	//コンストラクタ
	public Human(){
	}
	//getter･setter(なまえ)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//getter･setter(性別)
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}

	//getter･setter(身長)
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	//getter･setter(体重)
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	//getter･setter(たいりょく)
	public int getVitality() {
		return vitality;
	}
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	//getter･setter(まりょく)
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}

	//はなす
	public void talk(String about){
		System.out.println(about);
	}
	//たべる
	public void eatFood(String food){

		int foodType = 0;
		if(food == "やくそう"){
			foodType = 1;
		}else if (food == "まほうのみず"){
			foodType = 2;
		}else{
			foodType = 3;
		}
		digestFood(foodType);	//食べ物を消化する
	}

	//消化する
	private void digestFood(int foodType){
		if(foodType == 1){
			vitality += 10;	//たいりょくを10回復
		}else if (foodType == 2){
			magic += 10;	//まりょくを10回復
		}else{
			vitality += 1;	//たいりょくを1回復
		}
	}

	//標準攻撃メソッド
	public void attack(Human target){
		String name = this.name;
		int h = rand.nextInt(50);
		System.out.println( name + "の攻撃！");
		target.setVitality(target.getVitality() - h);
		System.out.println( target.getName() + " は " +  h + "のダメージをうけた");
		System.out.println("");
	}
	
	
}