/*
 * 	Ethan Yoder
 * 	October 17, 2017
 * 	MLB-themed example with connecting a Java application to a MySQL database
 */

import java.sql.*;
import java.util.Scanner;

public class MLBPlayoffs {

	public static void main(String[] args) {
		
		//connection string
		String dbUrl = "jdbc:mysql://localhost/mlbplayoffs";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			//adds security credentials to the connection
			Connection con = DriverManager.getConnection (dbUrl, "root", "root");
			Statement stmt;
			ResultSet rs;
			Scanner sc = new Scanner(System.in);
			int option = 0;
			int score1, score2;
			String team1, team2;
		
			while (option != 3) {
				System.out.println("Choose option: 1 to display team's records, 2 to submit a score, 3 to exit");
				option = sc.nextInt();
				if (option == 1) {
					stmt = con.createStatement();
					rs = stmt.executeQuery("SELECT * FROM team ORDER BY league;");
					System.out.println("\nAmerican League\n");
					for (int i = 0; i < 5; i++) {
						rs.next();
						System.out.println(rs.getString("name") + "\t" + rs.getInt("wins") + "-" + rs.getInt("losses"));
					}
					System.out.println("\nNational League\n");
					for (int i = 0; i < 5; i++) {
						rs.next();
						System.out.println(rs.getString("name") + "\t" + rs.getInt("wins") + "-" + rs.getInt("losses"));
					}
					System.out.println();
				}
				else if (option == 2) {
					System.out.println("Enter first team ID and score");
					team1 = sc.next();
					score1 = sc.nextInt();
					System.out.println("Enter second team ID and score");
					team2 = sc.next();
					score2 = sc.nextInt();
					if (score1 > score2) {
						stmt = con.createStatement();
						stmt.executeUpdate("UPDATE team SET wins = wins + 1 WHERE id = '" + team1 + "';");
						stmt = con.createStatement();
						stmt.executeUpdate("UPDATE team SET losses = losses + 1 WHERE id = '" + team2 + "';");
					}
					else if (score2 > score1) {
						stmt = con.createStatement();
						stmt.executeUpdate("UPDATE team SET wins = wins + 1 WHERE id = '" + team2 + "';");
						stmt = con.createStatement();
						stmt.executeUpdate("UPDATE team SET losses = losses + 1 WHERE id = '" + team1 + "';");
					}
				}
				else {
					con.close();
					sc.close();
					System.exit(0);
				}
			}
		}

		catch(ClassNotFoundException e) {
		e.printStackTrace();
		}

		catch(SQLException e) {
		e.printStackTrace();
		}

	}

}
