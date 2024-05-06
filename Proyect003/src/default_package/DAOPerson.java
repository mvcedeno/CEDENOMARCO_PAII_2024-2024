package default_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOPerson implements IDAO {
	Connection connection = null;
	public DAOPerson() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
	}
	public void closeConnection() throws SQLException {
		if(connection != null)
			connection.close();
	}
		
	public void createPerson(Person person) throws SQLException {		
		PreparedStatement ps = connection.prepareStatement("INSERT INTO person VALUES (?,?,?)");
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setInt(3, person.getAge());
		ps.execute();
		ps.close();
	}
	
	public Person readPerson(int id) {
		return null;
	}
	
	public void updatePerson(Person person) {
		
	}
	
	public void deletePerson(Person person) {
		
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
