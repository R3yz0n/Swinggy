// Person class (without table creation in constructor)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	Connection conn;

	private String name;
	private String email;
	private String password;
	private String gender;
	private String description;
	




	public Person(String name, String email, String password, String gender, String description) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.description = description;
	}

	private static final String CREATE_PERSON_TABLE = "CREATE TABLE IF NOT EXISTS Persons (id SERIAL NOT NULL PRIMARY KEY , name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), gender VARCHAR(10), description TEXT)";

	void connect() {

		String url = "jdbc:postgresql://localhost:5432/JDBC";

		String user = "sagar";
		String password = "sagar123";

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connected \n");
			this.createPersonTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createPersonTable() throws SQLException {

		Statement statement = conn.createStatement();
		System.out.println("hi");
		int result = statement.executeUpdate(CREATE_PERSON_TABLE);
		if (result == 0)
			System.out.println("Table created !\n\n");

	}

	void insertPerson() {
		String insertSQL = "INSERT INTO Persons (name, email, password, gender, description) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(insertSQL);

			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, gender);
			statement.setString(5, description);

			// Printing variables with labels
			System.out.println("name: " + name);
			System.out.println("email: " + email);
			System.out.println("password: " + password);
			System.out.println("gender: " + gender);
			System.out.println("description: " + description);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("\nA new person was inserted successfully.");
			} else {
				System.out.println("Insertion failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	public static void main(String[] args) throws Exception{
//
//		Person p = new Person("", "", "", "", "");
//
//		p.connect();
//		p.insertPerson();
//	}
}
