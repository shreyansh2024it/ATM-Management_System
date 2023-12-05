//5 steps for database connectivity ..... 
//register the driver
//create connection
//create statement
//execute query 
//close connection

package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
//            to register driver
//            Class.forName(com.mysql.cj.jdbc.Driver);
//            to create connection
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","yasu");
         s=c.createStatement();
        }catch(Exception e){
             System.out.println(e);
        }
    }
}
