package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date; 
//import java.util; cause ambiguity bcz Date class is in both sql and util packages so compiler is confused , we need to tell compiler form which package it will take date method

public class Fastcash extends JFrame implements ActionListener{
 JButton r1,r2,r3,r4,r5,r6,back;
 String pinNumber;   
    Fastcash(String pinno)
    {
        this.pinNumber = pinno;
        setLayout(null);
//      ImageIcon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(667, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImg = new JLabel(i3);
        add(atmImg);
        atmImg.setBounds(-30,-50,800,800);
        
        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(170,200,700,30);
        text.setFont(new Font("System",Font.BOLD,16));
        
        atmImg.add(text);
        
        r1 = new JButton("Rs 100");
        r1.setBounds(140,250,130,30);
        r1.setBackground(Color.BLACK);
        r1.setForeground(Color.WHITE);
        r1.addActionListener(this);
        atmImg.add(r1);
        
        r2 = new JButton("Rs 1000");
        r2.setBounds(140,290,130,30);
        r2.setBackground(Color.BLACK);
        r2.setForeground(Color.WHITE);
        r2.addActionListener(this);
        atmImg.add(r2);
        
        
        r3 = new JButton("Rs 2000");
        r3.setBounds(140,330,130,30);
        r3.setBackground(Color.BLACK);
        r3.setForeground(Color.WHITE);
        r3.addActionListener(this);
        atmImg.add(r3);
        
        r4 = new JButton("Rs 10,000");
        r4.setBounds(300,250,130,30);
        r4.setBackground(Color.BLACK);
        r4.setForeground(Color.WHITE);
        r4.addActionListener(this);
        atmImg.add(r4);
        
        r5= new JButton("Rs 20,000");
        r5.setBounds(300,290,130,30);
        r5.setBackground(Color.BLACK);
        r5.setForeground(Color.WHITE);
        r5.addActionListener(this);
        atmImg.add(r5);
        
        r6 = new JButton("Rs 50,000");
        r6.setBounds(300,330,130,30);
        r6.setBackground(Color.BLACK);
        r6.setForeground(Color.WHITE);
        r6.addActionListener(this);
        atmImg.add(r6);
        
        back = new JButton("Back");
        back.setBounds(220,370,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        atmImg.add(back);
        
        setSize(750,750);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }else{
             String amount =  ((JButton)a.getSource()).getText().substring(3);
             Conn c = new Conn();
            try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' ");
            int balance = 0;

              while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                }else{
                    balance= balance - Integer.parseInt(rs.getString("amount")); 
                }
              }
            
              if(a.getSource()!=back && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
               }
            Date date = new Date();
            String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawl successfully");
          
            setVisible(true);
            new Transaction(pinNumber).setVisible(true);
          }catch(Exception e){
              System.out.println(e);
          }            
       }
    }
    public static void main(String args[]) {
       new Fastcash("");
    }
}
