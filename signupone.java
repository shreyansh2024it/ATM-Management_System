
//make frame using setsize , setlocation , setvisible (swing class)
//make labels : create obj , set font , set bounds and add (awt class)
//recolor bgcolor of frame , setlayout as null 
//for event listenter awt.event class
package bank.management.system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
//paackage for jcalendaar file
import com.toedter.calendar.JDateChooser;
public class signupone extends JFrame implements ActionListener{

    int n1;
    String n;
    JTextField nametxtfield,fnametxtfield,emailtxtfield,addresstxtfield,citytxtfield,statetxtfield,pintxtfield;
    JButton next;
    JRadioButton male,female,others,married,unmarried,other;
    JDateChooser datechooser;
      
      signupone()
    {
//        making frame
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        //to remove by defalult border layout
        setLayout(null);
        
//        to set background clor of frame 
        getContentPane().setBackground(Color.WHITE);
        
//        random number generation util class
        Random r1 = new Random();
        n1 = Math.abs(r1.nextInt()%10000);
        String n = String.valueOf(n1);
        
        JLabel formno = new JLabel("APPLICATION  FORM  NO. "+n);
        formno.setBounds(150,10,600,50);
        formno.setFont(new Font("Osward",Font.BOLD,35));
        add(formno);
        
        JLabel persnldet = new JLabel("Page 1 : Personal Details...");
        persnldet.setBounds(290,70,600,30);
        persnldet.setFont(new Font("Raleway",Font.BOLD,20));
        add(persnldet);
        
        JLabel name= new JLabel("Name:");
        name.setBounds(100,130,200,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        nametxtfield = new JTextField();
        nametxtfield.setBounds(300,130,400,30);
        nametxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(nametxtfield);
        
         JLabel fname= new JLabel("Father's Name:");
         fname.setBounds(100,180,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);
        
         fnametxtfield = new JTextField();
        fnametxtfield.setBounds(300,180,400,30);
        fnametxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(fnametxtfield);
        
         JLabel dob= new JLabel("Date Of Birth:");
         dob.setBounds(100,230,200,30);
         dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300,230,400,30);
        datechooser.setForeground(Color.BLACK);
        datechooser.setFont(new Font("Raleway",Font.BOLD,15));
        add(datechooser);
        
         JLabel gender= new JLabel("Gender:");
         gender.setBounds(100,280,200,30);
         gender.setFont(new Font("Raleway",Font.BOLD,20));
         add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,280,100,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.BOLD,15));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(420,280,100,30);
        female.setFont(new Font("Raleway",Font.BOLD,15));
        female.setBackground(Color.WHITE);
        add(female);
        
        others = new JRadioButton("Others");
        others.setBounds(540,280,100,30);
        others.setFont(new Font("Raleway",Font.BOLD,15));
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel email= new JLabel("Email Address:");
        email.setBounds(100,330,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);
        
        emailtxtfield = new JTextField();
        emailtxtfield.setBounds(300,330,400,30);
        emailtxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(emailtxtfield);
        
        JLabel maritalstatus= new JLabel("Marital Status:");
        maritalstatus.setBounds(100,380,200,30);
        maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
        add(maritalstatus);

        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300,380,100,30);
        add(married);
        married.setFont(new Font("Raleway",Font.BOLD,15));
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(420,380,120,30);
        add(unmarried);
        unmarried.setFont(new Font("Raleway",Font.BOLD,15));
       
        other = new JRadioButton("Others");
         other.setBackground(Color.WHITE);
        other.setBounds(540,380,100,30);
        add(other);
        
        ButtonGroup maritalstatusgroup = new ButtonGroup();
        maritalstatusgroup.add(married);
        maritalstatusgroup.add(unmarried);
        maritalstatusgroup.add(other);
        
        other.setFont(new Font("Raleway",Font.BOLD,15));

        
         JLabel address= new JLabel("Address:");
        address.setBounds(100,430,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);
        
         addresstxtfield = new JTextField();
        addresstxtfield.setBounds(300,430,400,30);
        addresstxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(addresstxtfield);
        
         JLabel city= new JLabel("City:");
        city.setBounds(100,480,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);
        
           citytxtfield = new JTextField();
        citytxtfield.setBounds(300,480,400,30);
        citytxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(citytxtfield);
        
         JLabel state = new JLabel("State:");
         state.setBounds(100,530,200,30);
         state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);
        
        statetxtfield = new JTextField();
        statetxtfield.setBounds(300,530,400,30);
        statetxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(statetxtfield);
        
         JLabel pin= new JLabel("Pin:");
         pin.setBounds(100,580,200,30);
         pin.setFont(new Font("Raleway",Font.BOLD,20));
         add(pin);
        
        pintxtfield = new JTextField();
        pintxtfield.setBounds(300,580,400,30);
        pintxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        add(pintxtfield);
        
        next = new JButton("Next");
        next.setBounds(600,650,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }
     
   public void actionPerformed(ActionEvent e){
//         converting n to string : concatinate int number with "".
         String formno = ""+n1;  
         String name = nametxtfield.getText();
         String fname = fnametxtfield.getText();
         String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText(); 
         String gender = null;
         if(male.isSelected()){
             gender="Male";
         }else if(female.isSelected()){
             gender="Female";
         }else if(others.isSelected()){
             gender="Others";
         }
         
         String email = emailtxtfield.getText();
         String marital_status = null;
         if(married.isSelected()){
             marital_status="Married";
          }else if(unmarried.isSelected()){
              marital_status = "Unmarried";
          }else if(other.isSelected()){
              marital_status = "Others";
          }
         
         String address = addresstxtfield.getText();
         String city = citytxtfield.getText();
         String state = statetxtfield.getText();
         String pin = pintxtfield.getText();
         
         
         try{
             if(name.equals("")){
//                 Joptionpane helps in showing a popup
                 JOptionPane.showMessageDialog(null,"Name is Required");
             }
             else if(fname.equals("")){
                 JOptionPane.showMessageDialog(null,"Father's name is required");
             }
             else if(dob.equals("")){
                 JOptionPane.showMessageDialog(null,"DOB is required");
             }
             else if(email.equals("")){
                 JOptionPane.showMessageDialog(null,"email is required");
             }
             else if(gender == null){
                 JOptionPane.showMessageDialog(null,"gender is required");
             }
             else if(marital_status == null){
                 JOptionPane.showMessageDialog(null,"Marital Status is required");
             }
             else if(address.equals("")){
                 JOptionPane.showMessageDialog(null,"address is required");
             }
             else if(state.equals("")){
                 JOptionPane.showMessageDialog(null, "state is required");
             }
             else if(city.equals("")){
                 JOptionPane.showMessageDialog(null,"city is required");
             }
             else if(pin.equals("")){
                 JOptionPane.showMessageDialog(null, "pin is required");
             }else{
             Conn c = new Conn();
             String query = "insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital_status+"' , '"+address+"' , '"+city+"' ,'"+pin+"' , '"+state+"' )";
             c.s.executeUpdate(query);
             
             if(e.getSource()==next){
             setVisible(false);
             Signuptwo s = new Signuptwo(formno);
             s.setVisible(true);
                }
             }
         } catch(Exception ex){
             System.out.println(ex);
         } 
   }
    public static void main(String args[]) {
          new signupone();
    }
}
