package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Money {

	public static int sum = 0;
	public static int []sum1 = new int[5];

	public static void money() throws Exception {

		/******* Creating an Object to call method from Kounyu class *******/

		Kounyu k = new Kounyu();

		int thousand, fhundred, hundred, fifty, ten;
		System.out.println("\nお金の枚数を入力してください。");

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/******* Vending Machine maximum value *******/

		System.out.println("上限額は1990円です。");

		while (true) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("\n1000円 = ");
			BufferedReader thousand1 = new BufferedReader(new InputStreamReader(System.in));
			String str = thousand1.readLine();

			try {
				thousand = Integer.parseInt(str);
				sum1[0] = thousand;
			} catch (Exception e) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			System.out.print("500円 = ");
			BufferedReader fhundred1 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = fhundred1.readLine();

			try {
				fhundred = Integer.parseInt(str2);
				sum1[1] = fhundred;
			} catch (Exception e) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			System.out.print("100円 = ");
			BufferedReader hundred1 = new BufferedReader(new InputStreamReader(System.in));
			String str3 = hundred1.readLine();

			try {
				hundred = Integer.parseInt(str3);
				sum1[2] = hundred;
			} catch (Exception e) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			System.out.print("50円 = ");
			BufferedReader fifty1 = new BufferedReader(new InputStreamReader(System.in));
			String str4 = fifty1.readLine();

			try {
				fifty = Integer.parseInt(str4);
				sum1[3] = fifty;
			} catch (Exception e) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			System.out.print("10円 = ");
			BufferedReader ten1 = new BufferedReader(new InputStreamReader(System.in));
			String str5 = ten1.readLine();

			try {
				ten = Integer.parseInt(str5);
				sum1[4] = ten;
			} catch (Exception e) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			sum = (1000 * thousand + 500 * fhundred + 100 * hundred + 50 * fifty + 10 * ten);

			int[] price = new int[5];
			int count = 110;
			for (int i = 0; i < 5; i++) {
				price[i] = count;
				count += 10;
			}

			System.out.println("---------------");

			if (thousand < 0 || fhundred < 0 || hundred < 0 || fifty < 0 || ten < 0) {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

			else if (sum < price[0]) {
				System.out.println("合計 = " + sum + "円");
				System.out.println("\n最低金額110円です。\n再度入力してください。");
				continue;
			}

			else if (sum > 1990) {
				System.out.println("合計 = " + sum + "円");
				System.out.println("\n上限額1990円です。\n再度入力してください。");
				continue;
			}

			else {
				break;
			}
		}
		while (true) {
			System.out.println("合計 = " + sum + "円\n");
			System.out.println("投入金額" +sum+"円でよろしいですか?【OK(1)/NO(2)】");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str6 = br.readLine();
			String str7 = str6.intern();

			if (str7 == "1") {
				System.out.println("投入金額" +sum+"円確定しました。\n");
				
			} else if (str7 == "2") {
				System.out.println("投入金額" +sum+"円をお返しします。\n");
				Money.money();
				break;
			} else {
				System.out.println("最初から入力してください。");
				Money.money();
				
			}
			
			
			System.out.println("\n行動選択してください。");

			// DbCon.Henkyaku(sum);

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			System.out.println(" 購入(1)  返却(2)");

			BufferedReader bangou = new BufferedReader(new InputStreamReader(System.in));

			String str8 = bangou.readLine();
			String str9 = str8.intern();

			if (str9 == "1") {

				/******* Calling kounyu() method from kounyu Class *******/
				k.kounyu();
				break;
			}

			else if (str9 == "2") {
				System.out.println(sum + "円を返却しました。\nまたお願いします。\n");

				while (true) {
					System.out.println("\n       【商品一覧表】\n");
					DbCon.fetchdata();

					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("\n商品購入しますか？(y/n)");
					String str = br1.readLine();
					// char res = str.charAt(0);
					String ch1 = str.intern();

					if (ch1 == "y" || ch1 == "Y") {

						/******************** Calling mn.money(); ********************************/

						Money.money();
						break;
					} else if (ch1 == "n" || ch1 == "N") {
						System.out.println("またお願いします。\n");

						continue;

					} else if (ch1 == "kanri") {
						Kanri.kanri();

					} else if (ch1 == "exit") {
						System.out.println("操作停止しました。");
						break;
					} else {
						System.out.println("入力誤りです。\n再度入力してください。\n");
						continue;
					}
				}
				break;
			} else {
				System.out.println("入力誤りです。\n再度入力してください。");
				continue;
			}

		}
	}
}
