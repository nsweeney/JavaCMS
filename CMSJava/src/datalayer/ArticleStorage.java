package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import businesslayer.Article;

public class ArticleStorage {

	/**
	 * Used in displaying results of SELECT queries.
	 */
	private static ResultSet rs;
	/**
	 * Used for connecting to the database.
	 */
	private static Connection con;
	/**
	 * Used for SQL queries.
	 */
	private static Statement stmt;
	/**
	 * Used for SQL queries.
	 */
	private static PreparedStatement preparedSqlStatement;
	/**
	 * Used to hold the value of the PK for the SectionOrder.
	 */
	private int sectionOrderPrimaryKey;

	/**
	 * Initializes the connection to bookOrderApp.db.
	 * 
	 * @return boolean -Whether initializing the connection to the database was
	 *         successful or not.
	 */
	public static boolean initializeDatabaseConnection() {

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:articleapp.db");
			stmt = con.createStatement();
			System.out.println("DB connection success.");
			return true;
		} catch (ClassNotFoundException e) {
			// Perhaps these should be JOption pop ups for the user to see what
			// the error is.
			System.out.println("DB connection failure.");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("DB connection failure.");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Closes the database connection with bookOrderApp.db.
	 * 
	 * @return boolean -Whether closing the connection to the database was
	 *         successful or not.
	 */
	public static boolean disconnectDatabaseConnection() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			System.out.println("DB disconnection success.");
			return true;
		} catch (SQLException ex) {
			System.out.println("DB disconnection failure.");
			ex.printStackTrace();
			return false;
		}
	}

	public static void addArticleToDatabase(Article article) {
		try {

			initializeDatabaseConnection();

			// Initialize the prepared statement.
			try {
				stmt = con.createStatement();
				String sql = "INSERT INTO ARTICLE (TEXT) " + "VALUES (?) ";
				preparedSqlStatement = con.prepareStatement(sql);
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
				ex.printStackTrace();
			}

			// Sets values in prepared statement.
			try {
				preparedSqlStatement.setString(1, article.getContents());
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
				ex.printStackTrace();
			}

			// Execute prepared statement.
			try {
				preparedSqlStatement.executeUpdate();

			} catch (SQLIntegrityConstraintViolationException sqlicve) {
				System.out.println("SQL Integrity Constraint Exception: "
						+ sqlicve.getErrorCode());
				sqlicve.printStackTrace();
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
				ex.printStackTrace();
			}

			disconnectDatabaseConnection();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public static void createDBTables() {
		/*
		 * Used for database connection.
		 */
		Connection c = null;
		/*
		 * Used for SQL statements.
		 */
		Statement stmt = null;
		/*
		 * Used for storing the text of a SQL statement.
		 */
		String sql = "";

		try {
			/*
			 * Makes sure the class that implements the JDBC driver for SQLite
			 * is loaded and ready for use.
			 */
			Class.forName("org.sqlite.JDBC");
			/*
			 * Sets up connection to article.db. The .db file is created if it
			 * is not already present.
			 */
			c = DriverManager.getConnection("jdbc:sqlite:articleapp.db");
			System.out.println("Opened database successfully");

			// Create SECTIONORDER Table
			stmt = c.createStatement();
			sql = "CREATE TABLE ARTICLE "
					+ "(ARTICLE_ID INTEGER PRIMARY KEY   AUTOINCREMENT, "
					+ " TEXT           		TEXT)";

			stmt.executeUpdate(sql);
			System.out.println("Create ARTICLE Table success!");

			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out
				.println("All tables created successfully and connections closed.");

	}

}