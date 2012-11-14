import java.sql.*;

public class Chapter37 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
		System.out.println("Connection made");
		
		Statement statement = connection.createStatement();
		String sql;
		sql = "SELECT * FROM Student";
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		resultSet.next();
		System.out.println(resultSet.getString(1));
		System.out.println(resultSet.getString("MI"));
		System.out.println();
		
		/* sql = "SELECT * FROM student WHERE ssn = " + ssn;
		 * ResultSet resultSet = statement.executeQuery(sql);
		 * if ( resultSet.next() ) {
		 * 	System.out.println(resultSet.getString("Lastname");
		 * } else {
		 * 	System.out.println("SSN does NOT exists.");
		 * 
		 *  Use "resultSet.next()" to tell if there is data that matches the query.
		 *  If there are results "resultSet.next()" will return TRUE -- and then value, 
		 *  otherwise "resultSet.next()" will return FALSE -- and what is coded to show.
		 *  
		 */
		
		connection.close();
	}

}
