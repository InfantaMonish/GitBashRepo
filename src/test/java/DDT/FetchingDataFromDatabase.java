package DDT;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class FetchingDataFromDatabase {

	public static void main(String[] args)throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Students_Table", "root","root");
		
		Statement state=conn.createStatement();
		String query ="select * from student"; 
		
		ResultSet result =state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();
	}

}
