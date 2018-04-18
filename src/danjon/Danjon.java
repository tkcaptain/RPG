package danjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Danjon {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] map = {"","","encunt","","boss"};
	int i = 0;

	public void go() throws IOException{
		outside:while(true){
			System.out.println("どの方向に進む？");
			System.out.println("1:前、2:後ろ、3:右、4:左");
			String str = br.readLine();

			switch(str){
				case "1":
					i++;
					if(map[i].equals("")){
						System.out.println("何もなかった！");
						break;
					}else if(map[i].equals("encunt")){
						System.out.println("敵が現れた！");
					}
					break outside;
				case "2":
					System.out.println("その方向には進めない！");
					break;
				case "3":

					break;
				case "4":

					break;
			}

/*			if(str.equals("2")){		//switch使ってみる
				System.out.println("その方向には進めない！");
			}else if(str.equals("1")){
				i++;
				if(map[i].equals("")){
					System.out.println("何もなかった！");
				}else if(map[i].equals("encunt")){
					System.out.println("敵が現れた！");
					break;
				}
			}*/

		}

	}

}
