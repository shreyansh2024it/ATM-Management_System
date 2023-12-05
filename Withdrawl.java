
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.* ;
public class Withdrawl extends JFrame implements ActionListener{
       JButton deposit,back;
       String pinNumber;
       JTextField amount ;
       
    Withdrawl(String pinNumber)
    {
        this.pinNumber= pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(667, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImg = new JLabel(i3);
        add(atmImg);
        atmImg.setBounds(-30,-50,800,800);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setBounds(150,200,700,30);
        text.setFont(new Font("System",Font.BOLD,16));
        atmImg.add(text);
        
        amount = new JTextField();
        amount.setBounds(150,240,300,30);
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        atmImg.add(amount);
        
        deposit = new JButton("Withdraw");
        deposit.setBounds(300,310,130,30);
        deposit.addActionListener(this);
        atmImg.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(300,350,130,30);
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
        if(a.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter amount you want to deposit");
            }else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " +number+ " Withdraw successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                    }catch(Exception e){
                    System.out.print(e);
                }
            }
        }else if(a.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Withdrawl("");
    }
}
