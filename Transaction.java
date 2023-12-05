package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Transaction extends JFrame implements ActionListener{
 JButton deposit, withdrawl,pinchange,balanceenquiry,fastcash,minist,exit;
 String pinNumber;   
    Transaction(String pinno)
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
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140,250,130,30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        atmImg.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(140,290,130,30);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        atmImg.add(withdrawl);
        
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(140,330,130,30);
        pinchange.setBackground(Color.BLACK);
        pinchange.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        atmImg.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(300,250,130,30);
        balanceenquiry.setBackground(Color.BLACK);
        balanceenquiry.setForeground(Color.WHITE);
        balanceenquiry.addActionListener(this);
        atmImg.add(balanceenquiry);
        
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(300,290,130,30);
        fastcash.setBackground(Color.BLACK);
        fastcash.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        atmImg.add(fastcash);
        
        minist = new JButton("Mini Statement");
        minist.setBounds(300,330,130,30);
        minist.setBackground(Color.BLACK);
        minist.setForeground(Color.WHITE);
         minist.addActionListener(this);
        atmImg.add(minist);
        
        exit = new JButton("Exit");
        exit.setBounds(220,370,130,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        atmImg.add(exit);
        
        setSize(750,750);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==exit){
            System.exit(0);
        }else if(a.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(a.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(a.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinNumber).setVisible(true);
        }else if(a.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinNumber).setVisible(true);
        }else if(a.getSource() == balanceenquiry){
            setVisible(false);
            new Balanceenquiry(pinNumber).setVisible(true);
        }else if(a.getSource() == minist){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Transaction("");
    }
}
