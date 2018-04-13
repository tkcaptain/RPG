package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class main {
	//メイン処理
	public static void main(String[] args) throws IOException{
		Yuusya yuusya = new Yuusya();		//勇者オブジェクトを生成
		Wizard wizard = new Wizard();		//魔法使いオブジェクトを生成
		Cleric crelic = new Cleric();		//僧侶オブジェクトを生成
		Monster monster = new Monster();	//モンスターオブジェクトを生成
		LastBoss lastBoss = new LastBoss();	//ラスボスオブジェクトを生成
		boolean bool = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Human> list = new ArrayList<Human>();
		list.add(yuusya);
		list.add(wizard);
		list.add(crelic);

		ArrayList<Human> enemy = new ArrayList<Human>();
		enemy.add(lastBoss);
		enemy.add(monster);


		//敵があらわれた！
		System.out.println( lastBoss.getName() + " が あらわれた！");
		System.out.println( monster.getName() + " が あらわれた！");

		//バトル開始
		Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        if(randomNumber == 0){
        	bool = true;
        }else{
        	bool = false;
        }

		while(true){
			Human h =null;


	        if(bool){

	        	System.out.println("");
	        	System.out.println("/////////////////////////");
        		System.out.println("相手の攻撃！！");
        		System.out.println("/////////////////////////");
        		System.out.println("");

        		for(Human ene : enemy){

		        	int num = list.size();
		        	int dm = (int)(Math.random() * num);

		        	h = list.get(dm);
	        	    ene.attack(h);

	        	    if(! (h.getVitality() <= 0)){
		        		showStatus(h);
		        	}
	        	    if(h.getVitality() <= 0){
		        		list.remove(h);
		        		System.out.println(h.getName() + "はしんだ！");
		        		System.out.println("†††††††††††††††††††††");
		        		System.out.println();
		        		if(list.isEmpty()){
		        			break;
		        		}
		        	}
        		}

	        }else {
	        	System.out.println("");
        		System.out.println("/////////////////////////");
        		System.out.println("勇者たちの攻撃！！");
        		System.out.println("/////////////////////////");
        		System.out.println("");
	        	for(Human he : list){
	        	    System.out.println(he.getName() + "の攻撃！どうする？");
	        	    System.out.println("１：攻撃　２：特殊");
	        	    String str = br.readLine();
	        	    if(str.equals("1")){
	        	    	he.attack(lastBoss);
	        	    }else if(str.equals("2")){
		        	    	if(he.equals(yuusya)){
		        	    		((Yuusya) he).specialAttack(lastBoss);
		        	    	}else if (he.equals(wizard)){
		        	    		Wizard wi = (Wizard)he;
		        	    		wi.magicAttack(lastBoss);
		        	    	}else{
		        	    		Cleric cr = (Cleric)he;
		        	    		cr.healingMagic(he);
		        	    	}
	        	    }
	        	    if(lastBoss.getVitality() <=0){
	        	    	break;
	        	    }
	        	}

	        }
	        bool = !(bool);
	        /*switch(randomNumber){
	        case 0:
	        	int dm = rand.nextInt(2);
	        	if(dm == 0){
	        		h = yuusya;
	        	} else if (dm == 1){
	        		h = crelic;
	        	} else{
	        		h = wizard;
	        	}
	        	lastBoss.attack(h);
	        	break;
	        case 1:
	        	yuusya.attack(lastBoss);
	        	break;
	        case 2:
	        	crelic.attack(lastBoss);
	        	break;
	        case 3:
	        	wizard.attack(lastBoss);
	        	break;
	        }*/

			/*yuusya.specialAttack(lastBoss);		//勇者の攻撃
			wizard.magicAttack(lastBoss);		//魔法使いの攻撃
			lastBoss.specialEvilAttack(yuusya);	//ラスボスの攻撃
			crelic.healingMagic(yuusya);		//僧侶が勇者を回復
			//回復アイテムを使用
			System.out.println(yuusya.getName() + " は やくそう　をつかった");
			yuusya.eatFood("やくそう");
			System.out.println(wizard.getName() + " は まほうのみず　をつかった");
			wizard.eatFood("まほうのみず");
			System.out.println("");*/

			//ステータス表示


			//showStatus(lastBoss);

			if(list.isEmpty()){
				System.out.println(yuusya.getName() + "の体力は削り取られた！");
				System.out.println(yuusya.getName() + "たちは負けてしまった！");
				break;
			}else if(lastBoss.getVitality() <=0){
				System.out.println(lastBoss.getName() + "の体力を削り取った！");
				System.out.println(yuusya.getName() + "たちは勝利した！");
				break;
			}
		}



	}

	//ステータス表示メソッド
	private static void showStatus(Human target){
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


}