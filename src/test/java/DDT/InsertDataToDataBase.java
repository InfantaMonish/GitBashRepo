package DDT;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
public class InsertDataToDataBase {

	public static void main(String[] args)throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Students_Table", "root","root");
		
		Statement state=conn.createStatement();
		String query ="insert into student(id,first_name,last_name,address)values('2','sam','ram','goa')"; 
		
		int result =state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data created");
		}
		else
		{
			System.out.println("data not created");
		}
		conn.close();
	}

	

}
