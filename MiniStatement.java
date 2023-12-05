
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber){
        
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
         add(card);
         
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
             while(rs.next()){
                 card.setText("Card Number: "+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(13,16));
             }
         
         }catch(Exception e){
             System.out.print(e);
         }
         
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
             while(rs.next()){
                 mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
             }
         }catch(Exception e){
             System.out.print(e);
         }
         
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
   
    public static void main(String args[]) {
        // TODO code application logic here
        new MiniStatement("");
    }
}
