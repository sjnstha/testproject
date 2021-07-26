package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kanri {

	public static int id1, id2, id3, id4, id5, id6, id7,
	id8, id9, id10, id11, id12, 
	id13, id14, id15,id16,id17,id18,id19,id20;

	public static void kanri() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n管理者モード\n");
		// System.out.println(" モード選択 \n\n【売上】 【商品在庫】 【釣銭在庫】\n");
//		String str = br.readLine();
//		int num = Integer.parseInt(str);

		while (true) {
			System.out.println("                       モード選択 \n\n【売上確認】 【売上リセット】 【商品在庫】  【釣銭在庫】\n");
			String str = br.readLine();
			String ch = str.intern();
			if (ch == "uri") {
				Kanri.Ukanri();
				// break;
			} else if (ch == "syou") {
				Kanri.Skanri();
				// break;
			} else if (ch == "money") {
				Kanri.Mkanri();
				// break;
			}else if (ch == "reset") {
				DbCon.UUreset();
				//break;
			} else if (ch == "exit") {
				System.out.println("\n       【商品一覧表】\n");
				break;
			} else
				System.out.println("正しいパスワード入力してください。\n");
			continue;
		}

	}

	public static void Skanri() throws Exception {
		System.out.println("現在の商品在庫");
		DbCon.fetchdata();
		while (true) {
			System.out.println("\n商品補充しますか?(y/n)");
			BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
			String s1 = s.readLine();
			String s2 = s1.intern();

			if (s2 == "y" || s2 == "Y") {
				Kanri.Shozyu();

				break;

			} else if (s2 == "n" || s2 == "N") {
				System.out.println("前画面にいきます。");
				break;
			} else if (s2 == "withdraw") {
				Kanri.Shaisyutu();
				break;
			}else {
				System.out.println("入力誤りです。再度入力してください。");
				continue;
			}
		}

	}

	public static void Shozyu() throws Exception {

		
		BufferedReader shozyu = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n補充したい商品の個数を商品番号ごとに入力してください。");
			while (true) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("\n商品番号 = 1\n個数 = ");
				BufferedReader id11 = new BufferedReader(new InputStreamReader(System.in));
				String str1 = id11.readLine();

				try {
					id1 = Integer.parseInt(str1);

				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 2\n個数 = ");
				BufferedReader id12 = new BufferedReader(new InputStreamReader(System.in));
				String str2 = id12.readLine();

				try {
					id2 = Integer.parseInt(str2);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 3\n個数 = ");
				BufferedReader id13 = new BufferedReader(new InputStreamReader(System.in));
				String str3 = id13.readLine();

				try {
					id3 = Integer.parseInt(str3);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 4\n個数 = ");
				BufferedReader id14 = new BufferedReader(new InputStreamReader(System.in));
				String str4 = id14.readLine();

				try {
					id4 = Integer.parseInt(str4);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 5\n個数 = ");
				BufferedReader id15 = new BufferedReader(new InputStreamReader(System.in));
				String str5 = id15.readLine();

				try {
					id5 = Integer.parseInt(str5);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				if (id1 < 0 || id2 < 0 || id3 < 0 || id4 < 0 || id5 < 0) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				} else {
					break;
				}
			}
			System.out.println("\n商品の補充個数を確定してもよろしいですか?【OK(1)/NO(2)】");
			BufferedReader kosuu = new BufferedReader(new InputStreamReader(System.in));
			String str6 = kosuu.readLine();
			String str7 = str6.intern();

			if (str7 == "1") {
				System.out.println("補充完了しました。\n");
				DbCon.UpdateS();
				break;
			} else if (str7 == "2") {
				continue;
			} else {
				System.out.println("最初から入力してください。");
				continue;
			}
		}

	}
	
	public static void Shaisyutu() throws Exception {

		BufferedReader shai = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n排出したい商品の個数を番号ごとに入力してください。");
			while (true) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("\n商品番号 = 1\n個数 = ");
				BufferedReader id21 = new BufferedReader(new InputStreamReader(System.in));
				String str1 = id21.readLine();

				try {
					id16 = Integer.parseInt(str1);

				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 2\n個数 = ");
				BufferedReader id22 = new BufferedReader(new InputStreamReader(System.in));
				String str2 = id22.readLine();

				try {
					id17 = Integer.parseInt(str2);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 3\n個数 = ");
				BufferedReader id23 = new BufferedReader(new InputStreamReader(System.in));
				String str3 = id23.readLine();

				try {
					id18 = Integer.parseInt(str3);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 4\n個数 = ");
				BufferedReader id24 = new BufferedReader(new InputStreamReader(System.in));
				String str4 = id24.readLine();

				try {
					id19 = Integer.parseInt(str4);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n商品番号 = 5\n個数 = ");
				BufferedReader id25 = new BufferedReader(new InputStreamReader(System.in));
				String str5 = id25.readLine();

				try {
					id20 = Integer.parseInt(str5);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				if (id16 < 0 || id17 < 0 || id18 < 0 || id19 < 0 || id20 < 0) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				} else {
					break;
				}
			}
			System.out.println("\n商品の排出個数を確定してもよろしいですか?【OK(1)/NO(2)】");
			BufferedReader kosuu = new BufferedReader(new InputStreamReader(System.in));
			String str6 = kosuu.readLine();
			String str7 = str6.intern();

			if (str7 == "1") {
				System.out.println("排出完了しました。\n");
				DbCon.Withdraws();
				break;
			} else if (str7 == "2") {
				continue;
			} else {
				System.out.println("最初から入力してください。");
				continue;
			}
		}

	}
	

	public static void Mkanri() throws Exception {
		System.out.println("現在の釣銭在庫");
		DbCon.moneydata();
		while (true) {
			System.out.println("\nお金補充しますか?(y/n)");
			BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
			String s1 = s.readLine();
			String s2 = s1.intern();

			if (s2 == "y" || s2 == "Y") {
				Kanri.Mhozyu();

				break;

			} else if (s2 == "n" || s2 == "N") {
				System.out.println("前画面にいきます。");
				break;
			} else if (s2 == "withdraw") {
				Kanri.Msyukkin();
				break;
			} else {
				System.out.println("入力誤りです。再度入力してください。");
				continue;
			}
		}
	}

	public static void Mhozyu() throws Exception {

		BufferedReader shozyu = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n補充したいお金の枚数を番号ごとに入力してください。");
			while (true) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("\n番号 = 1\n枚数 = ");
				BufferedReader id11 = new BufferedReader(new InputStreamReader(System.in));
				String str1 = id11.readLine();

				try {
					id6 = Integer.parseInt(str1);

				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 2\n枚数 = ");
				BufferedReader id12 = new BufferedReader(new InputStreamReader(System.in));
				String str2 = id12.readLine();

				try {
					id7 = Integer.parseInt(str2);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 3\n枚数 = ");
				BufferedReader id13 = new BufferedReader(new InputStreamReader(System.in));
				String str3 = id13.readLine();

				try {
					id8 = Integer.parseInt(str3);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 4\n枚数 = ");
				BufferedReader id14 = new BufferedReader(new InputStreamReader(System.in));
				String str4 = id14.readLine();

				try {
					id9 = Integer.parseInt(str4);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 5\n枚数 = ");
				BufferedReader id15 = new BufferedReader(new InputStreamReader(System.in));
				String str5 = id15.readLine();

				try {
					id10 = Integer.parseInt(str5);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				if (id6 < 0 || id7 < 0 || id8 < 0 || id9 < 0 || id10 < 0) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				} else {
					break;
				}
			}
			System.out.println("\nお金の補充枚数を確定してもよろしいですか?【OK(1)/NO(2)】");
			BufferedReader kosuu = new BufferedReader(new InputStreamReader(System.in));
			String str6 = kosuu.readLine();
			String str7 = str6.intern();

			if (str7 == "1") {
				System.out.println("補充完了しました。\n");
				DbCon.UpdateM();
				break;
			} else if (str7 == "2") {
				continue;
			} else {
				System.out.println("最初から入力してください。");
				continue;
			}
		}

	}

	public static void Msyukkin() throws Exception {

		BufferedReader shozyu = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n出金したいお金の枚数を番号ごとに入力してください。");
			while (true) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("\n番号 = 1\n枚数 = ");
				BufferedReader id16 = new BufferedReader(new InputStreamReader(System.in));
				String str1 = id16.readLine();

				try {
					id11 = Integer.parseInt(str1);

				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 2\n枚数 = ");
				BufferedReader id17 = new BufferedReader(new InputStreamReader(System.in));
				String str2 = id17.readLine();

				try {
					id12 = Integer.parseInt(str2);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 3\n枚数 = ");
				BufferedReader id18 = new BufferedReader(new InputStreamReader(System.in));
				String str3 = id18.readLine();

				try {
					id13 = Integer.parseInt(str3);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 4\n枚数 = ");
				BufferedReader id19 = new BufferedReader(new InputStreamReader(System.in));
				String str4 = id19.readLine();

				try {
					id14 = Integer.parseInt(str4);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				System.out.print("\n番号 = 5\n枚数 = ");
				BufferedReader id20 = new BufferedReader(new InputStreamReader(System.in));
				String str5 = id20.readLine();

				try {
					id15 = Integer.parseInt(str5);
				} catch (Exception e) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				}

				if (id11 < 0 || id12 < 0 || id13 < 0 || id14 < 0 || id15 < 0) {
					System.out.println("入力誤りです。\n再度入力してください。");
					continue;
				} else {
					break;
				}
			}
			System.out.println("\nお金の出金枚数を確定してもよろしいですか?【OK(1)/NO(2)】");
			BufferedReader kosuu = new BufferedReader(new InputStreamReader(System.in));
			String str6 = kosuu.readLine();
			String str7 = str6.intern();

			if (str7 == "1") {
				System.out.println("出金完了しました。\n");
				DbCon.Withdrawm();
				break;
			} else if (str7 == "2") {
				continue;
			} else {
				System.out.println("最初から入力してください。");
				continue;
			}
		}

	}

	public static void Ukanri() throws Exception {
		System.out.println("現在の売上");

		DbCon.Sales();
		DbCon.Saleslist();
	}
	
	

}
