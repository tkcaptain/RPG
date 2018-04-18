package rpg;

import java.io.IOException;
import java.util.ArrayList;

import Item.Bomb;
import Item.Herb;
import Item.Item;
import battle.Battle;
import danjon.Danjon;

public class Main {
	public static Yuusya yuusya;
	public static Wizard wizard;
	public static Cleric crelic;
	public static Monster monster;
	public static LastBoss lastBoss;
	static boolean  hantei;
	//メイン処理
	public static void main(String[] args) throws IOException{
		Danjon da = new Danjon();
		da.go();

		yuusya = new Yuusya();		//勇者オブジェクトを生成
		wizard = new Wizard();		//魔法使いオブジェクトを生成
		crelic = new Cleric();		//僧侶オブジェクトを生成
		monster = new Monster();	//モンスターオブジェクトを生成
		lastBoss = new LastBoss();	//ラスボスオブジェクトを生成
//		boolean bool = true;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Human> list = new ArrayList<Human>();
		list.add(yuusya);
		list.add(wizard);
		list.add(crelic);

		ArrayList<Human> enemy = new ArrayList<Human>();
		enemy.add(lastBoss);
		enemy.add(monster);

		ArrayList<Item> item = new ArrayList<Item>();
		item.add(new Herb());
		item.add(new Bomb());

		//敵があらわれた！
		System.out.println(lastBoss.getName() + " が あらわれた！");
		System.out.println(monster.getName() + " が あらわれた！");

		//バトル開始
		Battle bt = new Battle();
		hantei = bt.battle(list, enemy, item);

		if(hantei){
			System.out.println(yuusya.getName() + "の体力は削り取られた！");
			System.out.println(yuusya.getName() + "たちは負けてしまった！");
		}else{
			System.out.println(lastBoss.getName() + "たちを消し去った！");
			System.out.println(yuusya.getName() + "たちは勝利した！");
		}

	}

	//ステータス表示メソッド
	public static void showStatus(Human target){
		System.out.println("- " + target.getName() + " の ステータス---");
		if(target.getGender() == 1){
			System.out.println("せいべつ ： 男");
		}else{
			System.out.println( "せいべつ ： 女");
		}
		System.out.println("しんちょう ： " + target.getLength());
		System.out.println("たいじゅう ： " + target.getWeight());
		System.out.println("たいりょく ： " + target.getVitality());
		System.out.println("まりょく ： " + target.getMagic());
		System.out.println("");

	}

	public static void shouLevelUp(Human target){
		System.out.println(target.getName() + "はレベルが上がった！");
		System.out.println("たいりょくが２あがった！： " + (target.getVitality() + 2));
		System.out.println("まりょくが２あがった！ ： " + (target.getMagic() + 2));
	}


}
