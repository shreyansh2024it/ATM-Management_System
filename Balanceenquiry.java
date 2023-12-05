
package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class Balanceenquiry extends JFrame implements ActionListener{
     String pinNumber;
      JButton back; 
    Balanceenquiry(String pinNumber){
       this.pinNumber = pinNumber;
        setLayout(null);
//      ImageIcon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(667, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImg = new JLabel(i3);
        add(atmImg);
        atmImg.setBounds(-30,-50,800,800);
        
        back = new JButton("BACK");
        back.setBounds(327,340,110,30  );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        atmImg.add(back);
        back.addActionListener(this);
        
         Conn c = new Conn();
         int balance=0;
        try{      
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' ");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount" ));
                      System.out.println(balance);
                 }else{
                      balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
        System.out.print(e);
        }
        
        JLabel text = new JLabel("Your Current bank balance is Rs "+ balance);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(140,200,600,30);
        atmImg.add(text);
        
        setSize(750,750);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(false);
        setVisible(true);
   }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Balanceenquiry("");
    }
}
