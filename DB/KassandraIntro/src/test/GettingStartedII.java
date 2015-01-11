package test;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class GettingStartedII {

	public static void main(String[] args) {
		ResultSet results;
		Row rows;
		//connect to cluster and keyspace demo
		Cluster cluster = Cluster.builder().addContactPoint("localhost")
						  .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
						  .withLoadBalancingPolicy(new TokenAwarePolicy(new DCAwareRoundRobinPolicy()))
						  .build();
		Session session = cluster.connect("demo");
		//Insert record using prepared statement
		PreparedStatement statement = session.prepare(
		" INSERT INTO users(lastname, age, city, email, firstname) "+
		" VALUES (?,?,?,?,?);");
		BoundStatement boundStatement = new BoundStatement(statement);
		session.execute(boundStatement.bind("Jones", 35,"Austin","bob@example.com", "Bob"));
		//
		
		Statement select = QueryBuilder.select().all().from("demo","users").where(QueryBuilder.eq("lastname","Jones"));
		results = session.execute(select);
		for (Row r: results){
			System.out.format("%s %d \n", r.getString("firstname"), r.getInt("age"));
		}
		//Update same user
		Statement update = QueryBuilder.update("demo","users")
						.with(QueryBuilder.set("age", 36))
						.where((QueryBuilder.eq("lastname","Jones")));
		session.execute(update);
		//Select and show the change
		select = QueryBuilder.select().all().from("demo", "users")
						.where(QueryBuilder.eq("lastname", "Jones"));
		results = session.execute(select);
		for(Row r:results){
			System.out.format("%s %d\n", r.getString("firstname"), r.getInt("age"));
		}
		//Delete user from table
		Statement delete = QueryBuilder.delete().from("users").where(QueryBuilder.eq("lastname","Jones"));
		results = session.execute(delete);
		//Query user
		select = QueryBuilder.select().all().from("demo","users");
		results = session.execute(select);
		for (Row r:results){
			System.out.format("%s %d %s %s %s \n", 
							   r.getString("lastname"), r.getInt("age")
							  ,r.getString("city"),r.getString("email"),r.getString("firstname"));
		}
		//Cleanup the connecion
		cluster.close();
	}
}
