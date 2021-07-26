package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/************* Declaring object to call Money method in 69 ***********/

		Money mn = new Money();

		System.out.println("        モード選択 \n    【販売】  【管理者】\n");
		// DbCon.

		while (true) {
			System.out.print("> ");

			/*********************** User Input **********************************/

			String str1 = br.readLine();
			String ch = str1.intern();

			if (ch != "han" && ch != "kan") {
				System.out.println("正しいパスワード入力してください。");
				continue;
			} else if (ch == "kan") {

				/******************** Calling Kanri method ********************************/

				Kanri.kanri();
				/******************** Print in the Screen ********************************/

				System.out.println("        モード選択 \n    【販売】  【管理者】\n");
				continue;

			} else if (ch == "han")
				System.out.println("       【WELCOME!!!】");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("\n       【商品一覧表】\n");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			while (true) {
				DbCon.fetchdata();

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n商品購入しますか？(y/n)");
				String str = br.readLine();
				// char res = str.charAt(0);
				String ch1 = str.intern();

				if (ch1 == "y" || ch1 == "Y") {

					/******************** Calling mn.money(); ********************************/

					mn.money();
					break;
				} else if (ch1 == "n" || ch1 == "N") {
					System.out.println("またお願いします。\n");
					System.out.println("\n       【商品一覧表】\n");
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

		}

	}
}
