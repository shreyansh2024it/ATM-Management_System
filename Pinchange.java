
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
//import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
   JButton change,back;
   JPasswordField brenewpin,bnewpin;
   JLabel chngepin,newpin;
   String pinNumber;
    Pinchange(String pinNumber){
        this.pinNumber = pinNumber;
         setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(667, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImg = new JLabel(i3);
        add(atmImg);
        atmImg.setBounds(-30,-50,800,800);
        
         chngepin = new JLabel("CHANGE YOUR PIN");
        chngepin.setBounds(190,180,700,30);
        chngepin.setFont(new Font("Raleway",Font.BOLD,18));
        atmImg.add(chngepin);
        
         newpin = new JLabel("New PIN: ");
        newpin.setBounds(120,220,300,30);
        newpin.setFont(new Font("Raleway",Font.BOLD,15));
        atmImg.add(newpin);
        
        bnewpin = new JPasswordField("");
        bnewpin.setBounds(258,220,200,30);
//        bnewpin.setBackground(Color.BLACK);
//        bnewpin.setForeground(Color.WHITE);
        atmImg.add(bnewpin);
        
        JLabel renewpin = new JLabel("Re-Enter New PIN: ");
        renewpin.setBounds(120,260,300,30);
        renewpin.setFont(new Font("Raleway",Font.BOLD,15));
        atmImg.add(renewpin);
        
        brenewpin = new JPasswordField("");
        brenewpin.setBounds(258,260,200,30);
        atmImg.add(brenewpin);
        
        change = new JButton("CHANGE");
        change.setBounds(327,320,110,30);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        atmImg.add(change);
        change.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(327,360,110,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        atmImg.add(back);
        back.addActionListener(this);

                
        setSize(750,750);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(false);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent a)
    {
     if(a.getSource()==change){
        try{
            String npin=bnewpin.getText();
            String rpin = brenewpin.getText() ;
//            if unqqual pins
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered pin does not exist");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new pin");
                return;
            }
            
             
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re enter new pin");
                return;
            }
//            to update pinin all three tables use update query
            Conn c = new Conn();
            String query1 = "update bank set pin ='"+npin+"' where pin='"+pinNumber+"'";
            String query2 = "update login set pinNumber ='"+npin+"' where pinNumber='"+pinNumber+"'";
            String query3 = "update signupthree set pinNumber ='"+npin+"' where pinNumber='"+pinNumber+"'";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"Pin changed successfully");
          
            setVisible(false);
            new Transaction(rpin).setVisible(true);
              
        }catch(Exception e){
            System.out.println(e);
        }
      }else{
         setVisible(false);
         new Transaction(pinNumber).setVisible(true);
     }
    }
    public static void main(String args[]) {
        new Pinchange("");   
    }
}
