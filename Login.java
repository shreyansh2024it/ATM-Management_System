
package bank.management.system;
import java.awt.event.*;
import javax.swing.*;
//to get image class
import java.sql.*;
//to get resultset class 
import java.awt.*;  
public class Login extends JFrame implements ActionListener{
     JButton signin,signup,clear;
     JTextField cardtextfield;
     JPasswordField pintextfield,pinno;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        //class used to put image is ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//        to scale image i ll make object of image class
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
//        i2 image object cant be pass directly to jlabel so 1st convert image into imageicon nd then pass
        ImageIcon i3 = new ImageIcon(i2);
//        we cant put icon directly on fram eso we use jlabel
        JLabel label = new JLabel(i3);
//        to cahnge location of label 
        label.setBounds(90,10,100,100);
//        now i ll put jlabel on frame using add functin 
        add(label);
        
        
        JLabel text = new JLabel("Welcome to ATM!");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250, 40,400,40);
        add(text);
        
         JLabel cardno = new JLabel("Card No:");
         cardno.setFont(new Font("Raleway",Font.BOLD,28));
         cardno.setBounds(120,150,150,40);
         add(cardno);
         
         cardtextfield = new JTextField();
          cardtextfield.setBounds(270,160,250,30);
          add(cardtextfield);
          
         
         JLabel pin = new JLabel("PIN:");
         pin.setFont(new Font("Raleway",Font.BOLD,28));
         pin.setBounds(120,220,400,40);
         add(pin);

          pintextfield = new JPasswordField();
          pintextfield.setBounds(270,228,250,30);
          add(pintextfield);
       
          signin = new JButton("SIGN IN");
          signin.setBounds(270,290,115,29);
          signin.setBackground(Color.BLACK);
          signin.setForeground(Color.WHITE);
          signin.addActionListener(this);
          add(signin);
          
          clear = new JButton("CLEAR");
          clear.setBounds(405,290,115,29);
          clear.setBackground(Color.BLACK);
          clear.setForeground(Color.WHITE);
          clear.addActionListener(this);
          add(clear);
          
         signup = new JButton("SIGN UP");
         signup.setBounds(270,340,250,29);
         signup.setBackground(Color.BLACK);
         signup.setForeground(Color.WHITE);
         signup.addActionListener(this);
         
         add(signup);
//       to recolor background of frame  
        getContentPane().setBackground(Color.WHITE);
//        to set size of frame
        setSize(800,480);
        setVisible(true);   
        setLocation(350,200);
    }
    
    //when we want to implement the interface we need to override the methods
         public void actionPerformed(ActionEvent a){
             if(a.getSource() == clear){
                 cardtextfield.setText("");
                 pintextfield.setText("");
             }
             else if(a.getSource() == signup){
                 setVisible(false);
                 new signupone().setVisible(true);
             }
             else if(a.getSource() == signin){
                 String cardno = cardtextfield.getText();
                 String pinno = pintextfield.getText();
                 
                 try{
                     if(cardno.equals("")){
                         JOptionPane.showMessageDialog(null,"Card NUmber is empty" );
                 }else if(pinno.equals("")){
                         JOptionPane.showMessageDialog(null,"Card NUmber is empty");
                     }else{
                         Conn c = new Conn();
                         ResultSet r = c.s.executeQuery("select * from login where CardNumber='"+cardno+"' and pinNumber='"+pinno+"'");
                         if(r.next()){
                         setVisible(false);
                         new Transaction(pinno).setVisible(true);
                         }else{
                             JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                         }
                     }
                 }catch(Exception e){
                     System.out.print(e);
                 }
                 
             }
         }
    public static void main(String args[]) {
        Login l1 = new Login();
    }
}
