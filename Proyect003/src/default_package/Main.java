package default_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		
		try {
			
			Person person = new Person(3, "David", 50);

			DAOPerson dao = new DAOPerson();
			dao.createPerson(person);
			
			/*Statement statement = connection.createStatement();
			
			//creando datos en DB -> CREATE
			statement.execute("INSERT INTO person VALUES (2, 'Jorge', 25)");
			
			//obteniendo datos en DB -> READ
			ResultSet result = statement.executeQuery("SELECT * FROM person");
			while(result.next())
				System.out.println("Persona: " + result.getString("name"));
			
			//actualizar datos -> UPDATE
			statement.execute("UPDATE person SET age=35 WHERE id = 1");
			
			//borrar datos -> DELETE
			statement.execute("DELETE FROM person WHERE id=2");
			
			//CRUD
			
			statement.close();		
			connection.close();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
