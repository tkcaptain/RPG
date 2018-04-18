package battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import Item.Item;
import rpg.Human;
import rpg.Main;

public class Battle {

	public boolean battle(ArrayList<Human> player, ArrayList<Human> enemy , ArrayList<Item> item) throws IOException{
		boolean bool = true;
		boolean hantei = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
	        	System.out.println("-------------------------");
        		System.out.println("|     相手の攻撃！！    |");
        		System.out.println("-------------------------");
        		System.out.println("");

        		for(Human ene : enemy){
		        	int num = player.size();
		        	int dm = (int)(Math.random() * num);
		        	h = player.get(dm);
		        	randomNumber = rand.nextInt(3);
		        	switch(randomNumber){
		        	case 0 :
		        		ene.attack(h);
		        		break;
		        	case 1 :
		        		ene.attack(h);
		        		break;
		        	case 2 :
		        		ene.specialEvilAttack(h);
		        	}

	        	    if(! (h.getVitality() <= 0)){
		        		Main.showStatus(h);
		        	}
	        	    if(h.getVitality() <= 0){
	        	    	player.remove(h);
		        		System.out.println(h.getName() + "はしんだ！");
		        		System.out.println("†††††††††††††††††††††");
		        		System.out.println();
		        		if(player.isEmpty()){
		        			break;
		        		}
		        	}
        		}
	        }else {
	        	Human enem = null;
	        	System.out.println("");
        		System.out.println("-------------------------");
        		System.out.println("|    勇者たちの攻撃！！ |");
        		System.out.println("-------------------------");
        		System.out.println("");
	        	for(Human he : player){
	        	    System.out.println(he.getName() + "のターン！どうする？"); //攻撃の選択
	        	    System.out.println("１：たたかう　２：アイテム"); //行動の選択
	        	    String str0 = br.readLine();
	        	    if(str0.equals("1")){
	        	    	System.out.println("どうする？"); //行動の選択
		        	    System.out.println("１：攻撃　２：特殊"); //行動の選択
		        	    String str = br.readLine();
		        	    if(str.equals("2") && he.getName().equals("そうりょ")){
		        	    	System.out.println("誰に使う？"); //対象の選択
			        	    for(int i = 0; player.size() > i; i++){
			        	    	System.out.println((i + 1) + ":" +  player.get(i).getName());
			        	    }
			        	    String str5 = br.readLine();
	        	    		he.specialAttack(player.get(Integer.parseInt(str5) - 1));
		        	    }else{
		        	    	System.out.println("誰に攻撃する？");
			        	    for(int i = 0; enemy.size() > i; i++){
			        	    	System.out.println((i + 1) + ":" +  enemy.get(i).getName());
			        	    }
			        	    String str2 = br.readLine();
			        	    enem = enemy.get(Integer.parseInt(str2) - 1);
			        	    if(str.equals("1")){
			        	    	he.attack(enem);
			        	    }else if(str.equals("2")){
			        	    	if(he.getMagic() < 10){
			        	    		System.out.println("しかしMPが足りなかった！");
			        	    	}else{
				        	    	he.specialAttack(enem);
				        	    }
			        	    }
		        	    }
	        	     }else if(str0.equals("2")){
	        	    	System.out.println("どれを使う？"); //種類の選択
		        	    for(int i = 0; item.size() > i; i++){
		        	    	System.out.println((i + 1) + ":" +  item.get(i).getName());
		        	    }
		        	    String str3 = br.readLine();

		        	    System.out.println("誰に使う？"); //対象の選択
		        	    ArrayList<Human> tai = null;
		        	    if(str3.equals("1")){
		        	    	tai = player;
		        	    }else if(str3.equals("2")){
		        	    	tai = enemy;
		        	    }
		        	    for(int i = 0; tai.size() > i; i++){
		        	    	System.out.println((i + 1) + ":" +  tai.get(i).getName());
		        	    }

		        	    String str4 = br.readLine();
		        	    enem = enemy.get(Integer.parseInt(str4) - 1);
		        	    Item it = item.get(Integer.parseInt(str3)-1);
		        	    if(str3.equals("1")){
		        	    	it.huse(player.get(Integer.parseInt(str4) - 1)); //回復処理
		        	    }else if(str3.equals("2")){
		        	    	it.duse(enemy.get(Integer.parseInt(str4) - 1)); //ダメージ処理
		        	    }
		        	    //list.remove(h);
	        	    }

	        	    if(enem.getVitality() <= 0){
		        		enemy.remove(enem);
		        		System.out.println(enem.getName() + "を倒した！");
		        		System.out.println("♭♭♭♭♭♭♭♭♭♭");
		        		System.out.println();
		        		if(enemy.isEmpty()){
		        			break;
		        		}
		        	}
	        	}

	        }
	        bool = !(bool);

	        //戦闘終了判定
			if(player.isEmpty()){
				hantei = true;
				break;
			}else if(enemy.isEmpty()){
				hantei = false;
				break;
			}
		}
		return hantei;
	}

}
