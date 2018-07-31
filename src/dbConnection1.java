

import java.sql.*;

import javax.swing.JOptionPane;


public class dbConnection1 {
	
	//for test
	
	
//JDBC and database properties
	
public  Connection getConnection(){
	
Connection conn = null;
try{

Class.forName("org.sqlite.JDBC"); 

conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sohanbappy-pc\\workspace\\sqlite\\MessMealSystem.sqlite","","");

if(conn != null){ 

//	JOptionPane.showMessageDialog(null,"DB connected");
 	
}
else{ 
	
	JOptionPane.showMessageDialog(null,"Failed to connect !!");
 	} 
}
catch(Exception e){
	
	JOptionPane.showMessageDialog(null,"Problem"+e);
	
return null;
 	
}
return conn;
}

}