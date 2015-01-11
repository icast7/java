package test;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class GettingStartedI {

	public static void main(String[] args){
		Cluster cluster;
		Session session;
		//Connect
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("demo");
		//Inser 1 record
		session.execute(" INSERT INTO users (lastname, age, city, email, firstname) "
				  + " VALUES ('Jones', 35, 'Austin','bob@example.com','Bob') ");
		session.execute(" INSERT INTO users (lastname, age, city, email, firstname) "
				  + " VALUES ('Yones', 31, 'Brooklyn','carmen@example.com','Carmen') ");
		session.execute(" INSERT INTO users (lastname, age, city, email, firstname) "
				  + " VALUES ('Bosworth', 24, 'San Mateo','cassandra@example.com','Cassandra') ");

		//Query record
		ResultSet results = session.execute( "SELECT * FROM users WHERE lastname = 'Jones' ");
		for (Row r: results){
			System.out.format("%s %d\n", r.getString("firstname"), r.getInt("age"));
		}
		//Update user with a new age
		session.execute("update users set age = 36 where lastname = 'Jones'");
		//Select ans show change
		results = session.execute("select * from users where lastname = 'Jones'");
		for (Row r : results){
			System.out.format("%s %d\n", r.getString("firstname"), r.getInt("age"));
		}
		//Delete user from users table
		session.execute("DELETE FROM users WHERE lastname = 'Jones'");
		//Show the result is gone
		results = session.execute("SELECT * FROM users");
		for (Row r : results){
			System.out.format("%s %s %d %s %s\n", 
					r.getString("lastname"), r.getString("firstname"), r.getInt("age"), 
					r.getString("city"), r.getString("email"));
		}
		cluster.close();
	}
}