
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
   
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit,cancel;
    JLabel page3,type,cardno,number,cline,pin,pline,services;
    JCheckBox confirm;
    String formno;
    Signupthree(String formno)
    {
        this.formno=formno;
//        creating frame 
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setLayout(null);
        
//        changing background color of frame 
       getContentPane().setBackground(Color.WHITE);
       
//       now make elements using JLabel , JRadioButton , JCheckbox
       page3 = new JLabel("Page 3: Account Details");
       page3.setBounds(300,40,400,30);
       page3.setFont(new Font("Raleway" , Font.BOLD,20));
       add(page3);
       
       type = new JLabel("Account Type");
       type.setBounds(90,92,400,30);
       type.setFont(new Font("Raleway" , Font.BOLD,20));
       add(type);
       
       r1 = new JRadioButton("Saving Account");
       add(r1);
       r1.setBackground(Color.WHITE);
       r1.setBounds(92,127,300,20);
       r1.setFont(new Font("Raleway",Font.BOLD,13));
       
       r2 = new JRadioButton("Fixed Deposit Account");
       add(r2);
       r2.setBackground(Color.WHITE);
       r2.setBounds(500,127,300,20);
       r2.setFont(new Font("Raleway",Font.BOLD,13));
       
       r3 = new JRadioButton("Current Account");
       add(r3);
       r3.setBackground(Color.WHITE);
       r3.setBounds(92,157,300,20);
       r3.setFont(new Font("Raleway",Font.BOLD,13));
       
       r4 = new JRadioButton("Recurring Deposit Account");
       add(r4);
       r4.setBackground(Color.WHITE);
       r4.setBounds(500,157,300,20);
       r4.setFont(new Font("Raleway",Font.BOLD,13));
       
       ButtonGroup b1 =new ButtonGroup();
       b1.add(r1);
       b1.add(r2);
       b1.add(r3);  
       b1.add(r4);
          
       cardno = new JLabel("Card Number:");
       cardno.setBounds(100,220,400,30);
       cardno.setFont(new Font("Raleway" , Font.BOLD,20));
       add(cardno);
       
       number = new JLabel("XXXX-XXXX-XXXX-4184");
       number.setBounds(400,220,450,30);
       number.setFont(new Font("Raleway" , Font.BOLD,20));
       add(number);
       
       
       cline = new JLabel("Your 16 Digit Card Number");
       cline.setBounds(100,245,450,30);
       cline.setFont(new Font("Raleway" , Font.BOLD,10));
       add(cline);
       
       pin = new JLabel("PIN:");
       pin.setBounds(100,290,450,30);
       pin.setFont(new Font("Raleway" , Font.BOLD,20));
       add(pin);
       
       JLabel pinno = new JLabel("XXXX");
      pinno.setBounds(400,290,450,30);
       pinno.setFont(new Font("Raleway" , Font.BOLD,20));
       add(pinno);
       
       pline = new JLabel("Your 4 Digit Password");
       pline.setBounds(100,315,450,30);
       pline.setFont(new Font("Raleway" , Font.BOLD,10));
       add(pline);
       
       services = new JLabel("Services Required:");
       services.setBounds(100,365,450,30);
       services.setFont(new Font("Raleway" , Font.BOLD,20));
       add(services);
       
       c1 = new JCheckBox("ATM CARD");
       add(c1);
       c1.setBackground(Color.WHITE);
       c1.setBounds(112,410,300,20);
       c1.setFont(new Font("Raleway",Font.BOLD,13));
       
       c2 = new JCheckBox("Mobile Banking");
       add(c2);
       c2.setBackground(Color.WHITE);
       c2.setBounds(112,443,300,20);
       c2.setFont(new Font("Raleway",Font.BOLD,13));
       

       c3 = new JCheckBox("Cheque Book");
       add(c3);
       c3.setBackground(Color.WHITE);
       c3.setBounds(112,476,300,20);
       c3.setFont(new Font("Raleway",Font.BOLD,13));
       

       c4 = new JCheckBox("Internet Banking");
       add(c4);
       c4.setBackground(Color.WHITE);
       c4.setBounds(450,410,300,20);
       c4.setFont(new Font("Raleway",Font.BOLD,13));
       
       c5 = new JCheckBox("EMAIL & SMS Alerts");
       add(c5);
       c5.setBackground(Color.WHITE);
       c5.setBounds(450,443,300,20);
       c5.setFont(new Font("Raleway",Font.BOLD,13));
       
       c6 = new JCheckBox("E-Statement");
       add(c6);
       c6.setBackground(Color.WHITE);
       c6.setBounds(450,476,300,20);
       c6.setFont(new Font("Raleway",Font.BOLD,13));

        confirm = new  JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        add(confirm);
        confirm.setBounds(112,550,700,30);
        confirm.setFont(new Font("Raleway",Font.BOLD,14));
        confirm.setBackground(Color.WHITE);
        
        submit = new JButton("Submit");
        add(submit);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,13));
        submit.setBounds(300,600,100,30);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        add(cancel);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,13));
        cancel.setBounds(450,600,100,30);
        cancel.addActionListener(this);
    }
   
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==submit){
            String accType=null;
            if(r1.isSelected()){
                accType="Saving Account";
            }else if(r2.isSelected()){
                accType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accType="Current Account";
            }else if(r4.isSelected()){
                accType="Recurring Deposit Account";
            }
            
            Random r1 = new Random();
            String cardNumber = "" + Math.abs((r1.nextLong()%90000000L)+5040936000000000L);
            
            String pinNumber = ""+Math.abs((r1.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=facility+"\nATM CARD";
            }
            if(c2.isSelected()){
                facility=facility+"\nMobile Banking";
            }if(c3.isSelected()){
                facility=facility+"\nCheque Book";
            }if(c4.isSelected()){
                facility=facility+"\nInternet Banking";
            }if(c5.isSelected()){
                facility=facility+"\nEMAIL & SMS Alerts";
            }if(c6.isSelected()){
                facility=facility+"\nE-Statement";
            }
            try{
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    conn.s.executeUpdate(query1);
                    new Signupthree(formno).setVisible(false);
                    
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null," Card Number "+ cardNumber +"\n Pin Number "+pinNumber+"\n");

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                    
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        if(a.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
     }
    public static void main(String args[]) {
      Signupthree s1 = new Signupthree("");
    }
}
