package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DbCon {

	/*************** Using Vector to hold Data From DB **************/
	static Connection cnx = null;
	static int oturi = 0;
	static Vector vec = new Vector();
	static Vector vec1 = new Vector();
	static Vector vec2 = new Vector();

	/**************** Method to connect with DB ********************/

	public static Connection connect() throws SQLException, InstantiationException {

//		Connection cnx = null;
		String url, username = null, password = null;

		/******************** DB URL *********************/

		url = "jdbc:mysql://localhost:3306/vending";

		/******************** User Name ********************/

		username = "root";

		/***************** Default PW ********************/

		password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			cnx = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return cnx;
	}

	/*************** Method to import DATA from DB ************************/

	public static void fetchdata() throws Exception {

		/******************** Calling Connection method *********************/

		Connection cnx = connect();

		/*************** Selection of Table name goods from DB *****************/

		String sql = "select * from goods";

		try {
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			vec.clear();
			while (rs.next()) {
				vec.add(rs.getInt(1));
				vec.add(rs.getInt(2));
				vec.add(rs.getInt(3));
				vec.add(rs.getString(4));

				System.out.println("商品番号 = " + rs.getInt(1) + "\t" + " " + "商品名 = " + rs.getString(4) + "\n" + "在庫数 = "
						+ rs.getInt(2) + "個" + "\t" + " " + "価格 = " + rs.getInt(3) + "円" + "\n");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/******* Method To update DATA of table goods *************/

	public static void zaiko(int i) throws Exception {

		int a = 0;
		if (i == 1) {
			a = (int) vec.get(1);
		} else if (i == 2) {
			a = (int) vec.get(5);
		} else if (i == 3) {
			a = (int) vec.get(9);
		} else if (i == 4) {
			a = (int) vec.get(13);
		} else if (i == 5) {
			a = (int) vec.get(17);
		}

		Connection cnx = connect();

		/********** updating table goods stock ****************/

		String sql = "UPDATE `goods` SET `stock`= " + (a - 1) + " WHERE id = " + i;

		try {
			Statement st = cnx.createStatement();
			int rs = st.executeUpdate(sql);

			/********* Calling fetchdata method of DbCon class ***********/
			fetchdata();

			cnx.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/******************** Method to import table price ********************/
	public static void moneydata() throws Exception {
		Connection cnx = connect();

		/********** importing data from table price *****************/
		String sql = "select * from price";

		try {
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			vec.clear();
			while (rs.next()) {
				vec.add(rs.getInt(1));
				vec.add(rs.getInt(2));
				vec.add(rs.getInt(3));

				System.out.println("\n番号 = " + rs.getInt(1) + "\n" + "お金 = " + rs.getInt(2) + "円" + "\n在庫 = "
						+ rs.getInt(3) + "枚" + "\n");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void Uriage(int i) throws Exception {
		Connection cnx = connect();

		// String sql = "select * from sales";
		DbCon.Sales();

		int sum = (int) vec1.get(1);
		int sum1 = (int) vec1.get(3);
		int sum2 = (int) vec1.get(5);
		int sum3 = (int) vec1.get(7);
		int sum4 = (int) vec1.get(9);

		int a = 0, b = 0, c = 0, d = 0, e = 0;
		if (i == 1) {
			a = 110;
			String sql1 = "UPDATE `sales` SET `amount`= " + (sum + a) + " WHERE id = 1";
			try {
				Statement st1 = cnx.createStatement();
				st1.executeUpdate(sql1);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 2) {
			b = 120;
			String sql2 = "UPDATE `sales` SET `amount`= " + (sum1 + b) + " WHERE id = 2";
			try {
				Statement st2 = cnx.createStatement();
				st2.executeUpdate(sql2);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 3) {
			c = 130;
			String sql3 = "UPDATE `sales` SET `amount`= " + (sum2 + c) + " WHERE id = 3";
			try {
				Statement st3 = cnx.createStatement();
				st3.executeUpdate(sql3);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 4) {
			d = 140;
			String sql4 = "UPDATE `sales` SET `amount`= " + (sum3 + d) + " WHERE id = 4";
			try {
				Statement st4 = cnx.createStatement();
				st4.executeUpdate(sql4);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 5) {
			e = 150;
			String sql5 = "UPDATE `sales` SET `amount`= " + (sum4 + e) + " WHERE id = 5";
			try {
				Statement st5 = cnx.createStatement();
				st5.executeUpdate(sql5);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		}
		cnx.close();

	}

	public static void Saleslist() {
		int sum = 0;
		for (int i = 0; i < vec1.size(); i++) {
			System.out.println("\n商品番号 = " + vec1.get(i) + "\n売上 = " + vec1.get(i + 1) + "円");
			i++;
			sum += (int) vec1.get(i);
		}
		System.out.println("\n売上合計 = " + sum + "円\n");
	}

	public static void Sales() throws Exception {
		Connection cnx = connect();

		/********** importing data from table price *****************/
		String sql = "select * from sales";

		try {
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			vec1.clear();
			while (rs.next()) {
				vec1.add(rs.getInt(1));
				vec1.add(rs.getInt(2));

				// System.out.println("\n商品番号 = " + rs.getInt(1) + "\n売上 = " + rs.getInt(2) +
				// "円");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void UUreset() throws Exception {
		while (true) {
			System.out.println("売上リセットしますか？");
			BufferedReader reset = new BufferedReader(new InputStreamReader(System.in));
			String str8 = reset.readLine();
			String change = str8.intern();
			if (change == "yes") {
				DbCon.Ureset();
				break;
			} else if (change == "no") {
				break;
			} else {
				System.out.println("正しいパスワード入力してください。\n");
				continue;
			}
		}
	}

	public static void Ureset() throws Exception {
		Connection cnx = connect();

		String sql1 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 1;
		String sql2 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 2;
		String sql3 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 3;
		String sql4 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 4;
		String sql5 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 5;

		try {
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

		System.out.println("売上リセットされました。");
		DbCon.Sales();

	}

	/*** Creating Henkyaku Method ***/

	public static void Henkyaku(int i) throws Exception {

		int sum1 = Money.sum;

		while (true) {
			if (i == 1) {
				oturi = sum1 - (int) vec.get(2);
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 2) {
				oturi = sum1 - (int) vec.get(6);
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 3) {
				oturi = sum1 - (int) vec.get(10);
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 4) {
				oturi = sum1 - (int) vec.get(14);
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 5) {
				oturi = sum1 - (int) vec.get(18);
				System.out.println("お釣り = " + oturi + "円\n");
				// DbCon.UPMN();
				break;

			}

		}

	}

	public static void UpdateM() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id6;
		j = Kanri.id7;
		k = Kanri.id8;
		l = Kanri.id9;
		m = Kanri.id10;

		Connection cnx = connect();

		a = (int) vec.get(2);

		b = (int) vec.get(5);

		c = (int) vec.get(8);

		d = (int) vec.get(11);

		e = (int) vec.get(14);

		String sql1 = "UPDATE `price` SET `stock`= " + (a + i) + " WHERE id = " + (int) vec.get(0);
		String sql2 = "UPDATE `price` SET `stock`= " + (b + j) + " WHERE id = " + (int) vec.get(3);
		String sql3 = "UPDATE `price` SET `stock`= " + (c + k) + " WHERE id = " + (int) vec.get(6);
		String sql4 = "UPDATE `price` SET `stock`= " + (d + l) + " WHERE id = " + (int) vec.get(9);
		String sql5 = "UPDATE `price` SET `stock`= " + (e + m) + " WHERE id = " + (int) vec.get(12);
		try {
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			DbCon.moneydata();
			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void UpdateS() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id1;
		j = Kanri.id2;
		k = Kanri.id3;
		l = Kanri.id4;
		m = Kanri.id5;

		Connection cnx = connect();

		a = (int) vec.get(1);

		b = (int) vec.get(5);

		c = (int) vec.get(9);

		d = (int) vec.get(13);

		e = (int) vec.get(17);

		String sql1 = "UPDATE `goods` SET `stock`= " + (a + i) + " WHERE id = " + (int) vec.get(0);
		String sql2 = "UPDATE `goods` SET `stock`= " + (b + j) + " WHERE id = " + (int) vec.get(4);
		String sql3 = "UPDATE `goods` SET `stock`= " + (c + k) + " WHERE id = " + (int) vec.get(8);
		String sql4 = "UPDATE `goods` SET `stock`= " + (d + l) + " WHERE id = " + (int) vec.get(12);
		String sql5 = "UPDATE `goods` SET `stock`= " + (e + m) + " WHERE id = " + (int) vec.get(16);
		try {
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			DbCon.fetchdata();
			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void Withdrawm() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id11;
		j = Kanri.id12;
		k = Kanri.id13;
		l = Kanri.id14;
		m = Kanri.id15;

		Connection cnx = connect();

		a = (int) vec.get(2);

		b = (int) vec.get(5);

		c = (int) vec.get(8);

		d = (int) vec.get(11);

		e = (int) vec.get(14);

		String sql1 = "UPDATE `price` SET `stock`= " + (a - i) + " WHERE id = " + (int) vec.get(0);
		String sql2 = "UPDATE `price` SET `stock`= " + (b - j) + " WHERE id = " + (int) vec.get(3);
		String sql3 = "UPDATE `price` SET `stock`= " + (c - k) + " WHERE id = " + (int) vec.get(6);
		String sql4 = "UPDATE `price` SET `stock`= " + (d - l) + " WHERE id = " + (int) vec.get(9);
		String sql5 = "UPDATE `price` SET `stock`= " + (e - m) + " WHERE id = " + (int) vec.get(12);
		try {
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			DbCon.moneydata();
			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void Withdraws() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id16;
		j = Kanri.id17;
		k = Kanri.id18;
		l = Kanri.id19;
		m = Kanri.id20;

		Connection cnx = connect();

		a = (int) vec.get(1);

		b = (int) vec.get(5);

		c = (int) vec.get(9);

		d = (int) vec.get(13);

		e = (int) vec.get(17);

		String sql1 = "UPDATE `goods` SET `stock`= " + (a - i) + " WHERE id = " + (int) vec.get(0);
		String sql2 = "UPDATE `goods` SET `stock`= " + (b - j) + " WHERE id = " + (int) vec.get(4);
		String sql3 = "UPDATE `goods` SET `stock`= " + (c - k) + " WHERE id = " + (int) vec.get(8);
		String sql4 = "UPDATE `goods` SET `stock`= " + (d - l) + " WHERE id = " + (int) vec.get(12);
		String sql5 = "UPDATE `goods` SET `stock`= " + (e - m) + " WHERE id = " + (int) vec.get(16);
		try {
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			DbCon.fetchdata();
			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void UPMN() throws InstantiationException, SQLException {
		
		Connection cnx = connect();
		String sql = "select * from price";

		try {
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			vec2.clear();
			while (rs.next()) {
				vec2.add(rs.getInt(3));
			}

			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		
		

		int a, b, c, d, e;
		String sql1 = null, sql2 = null, sql3 = null, sql4 = null, sql5 = null;

		
		a = (int) vec2.get(0);

		b = (int) vec2.get(1);

		c = (int) vec2.get(2);

		d = (int) vec2.get(3);

		e = (int) vec2.get(4);
		
		try {

			while (true) {
				if (oturi / 1000 >= 1) {
					sql1 = "UPDATE `price` SET `stock`= " + (a - (oturi / 1000)) + " WHERE id = 1";
					oturi -= (oturi / 1000)*1000;
					Statement st1 = cnx.createStatement();
					st1.executeUpdate(sql1);
					continue;
				} else if (oturi / 500 >= 1) {
					sql2 = "UPDATE `price` SET `stock`= " + (b - (oturi / 500)) + " WHERE id = 2";
					oturi -= (oturi / 500)*500;
					Statement st2 = cnx.createStatement();
					st2.executeUpdate(sql2);
					continue;
				} else if (oturi / 100 >= 1) {
					sql3 = "UPDATE `price` SET `stock`= " + (c - (oturi / 100)) + " WHERE id = 3";
					oturi -= (oturi / 100)*100;
					Statement st3 = cnx.createStatement();
					st3.executeUpdate(sql3);
					continue;
				} else if (oturi / 50 >= 1) {
					sql4 = "UPDATE `price` SET `stock`= " + (d - (oturi / 50)) + " WHERE id = 4";
					oturi -= (oturi / 50)*50;
					Statement st4 = cnx.createStatement();
					st4.executeUpdate(sql4);
					continue;
				} else if (oturi / 10 >= 1) {
					sql5 = "UPDATE `price` SET `stock`= " + (e - (oturi / 10)) + " WHERE id = 5";
					oturi -= (oturi / 10)*10;
					Statement st5 = cnx.createStatement();
					st5.executeUpdate(sql5);
				} else {
					break;
				}

				cnx.close();
			}
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}
	

	public static void mn() throws Exception {
		Connection cnx = connect();
		String sql = "select * from price";

		try {
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			vec2.clear();
			while (rs.next()) {
				vec2.add(rs.getInt(3));

			}

			int a, b, c, d, e;

			a = (int) vec2.get(0);

			b = (int) vec2.get(1);

			c = (int) vec2.get(2);

			d = (int) vec2.get(3);

			e = (int) vec2.get(4);

			String sql1 = "UPDATE `price` SET `stock`= " + (Money.sum1[0] + a) + " WHERE id = 1";
			String sql2 = "UPDATE `price` SET `stock`= " + (Money.sum1[1] + b) + " WHERE id = 2";
			String sql3 = "UPDATE `price` SET `stock`= " + (Money.sum1[2] + c) + " WHERE id = 3";
			String sql4 = "UPDATE `price` SET `stock`= " + (Money.sum1[3] + d) + " WHERE id = 4";
			String sql5 = "UPDATE `price` SET `stock`= " + (Money.sum1[4] + e) + " WHERE id = 5";
			Statement st1 = cnx.createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = cnx.createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = cnx.createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = cnx.createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = cnx.createStatement();
			st5.executeUpdate(sql5);

			cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

}
