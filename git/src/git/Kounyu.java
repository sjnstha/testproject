package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kounyu {
	public static void kounyu() throws Exception {
		

		/********* Creating an object to call method of class DbCon **********/

		DbCon con = new DbCon();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int sum1 = Money.sum;
		
		while(true) {
			
			System.out.println("商品番号選択で購入出来ます。\n商品番号選択してください。");

			int water = (int) DbCon.vec.get(1);
			int coke = (int) DbCon.vec.get(5);
			int fanta = (int) DbCon.vec.get(9);
			int yog = (int) DbCon.vec.get(13);
			int mon = (int) DbCon.vec.get(17);

			while (true) {
				String str = br.readLine();
				char res = str.charAt(0);

				if (res == '1' && water > 0 && sum1 >= 110) {
					System.out.println(DbCon.vec.get(3) + "を購入しました。\n");
					DbCon.Henkyaku((int) DbCon.vec.get(0));
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko((int) DbCon.vec.get(0));
					DbCon.Uriage((int) DbCon.vec.get(0));
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '2' && coke > 0 && sum1 >= 120) {
					System.out.println(DbCon.vec.get(7) + "を購入しました。\n");
					DbCon.Henkyaku((int) DbCon.vec.get(4));
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko((int) DbCon.vec.get(4));
					DbCon.Uriage((int) DbCon.vec.get(4));
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '3' && fanta > 0 && sum1 >= 130) {
					System.out.println(DbCon.vec.get(11) + "を購入しました。\n");
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko((int) DbCon.vec.get(8));
					DbCon.Henkyaku((int) DbCon.vec.get(8));
					DbCon.Uriage((int) DbCon.vec.get(8));
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '4' && yog > 0 && sum1 >= 140) {
					System.out.println(DbCon.vec.get(15) + "を購入しました。\n");
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko((int) DbCon.vec.get(12));
					DbCon.Henkyaku((int) DbCon.vec.get(12));
					DbCon.Uriage((int) DbCon.vec.get(12));
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '5' && mon > 0 && sum1 >= 150) {
					System.out.println(DbCon.vec.get(19) + "を購入しました。\n");

					/******* Calling DbCon.zaiko method from DbCon Class *******/
					DbCon.Henkyaku((int) DbCon.vec.get(16));
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko((int) DbCon.vec.get(16));
					DbCon.Uriage((int) DbCon.vec.get(16));
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else {
					System.out.println("在庫切れか、入力誤りです。\n再度入力してください。");
					continue;
				}
			   
			}
			System.out.println("\n続けて購入しますか？(y/n)");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			String str = br1.readLine();
			String res = str.intern();

			if (res != "y" && res != "Y" && res != "n" && res != "N") {
				
				System.out.println("入力誤りです。\n再度入力してください。\n");
				

				/******* Calling kounyu() method from kounyu Class *******/
				
			}

			else if (res == "y" || res == "Y") {
				Money.money();
				break;
			}
			else if(res == "n" || res == "N"){
				System.out.println("ご利用ありがとうございます。");
				System.out.println("またお願いします。");
				break;
			}
			else {
				break;
			}
		}
		
	}
}
