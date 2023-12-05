
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signuptwo extends JFrame implements ActionListener{
     JLabel religion , additionaldetails ,category,income,edu,occupation,pan,adhaar,seniorcitizen,existingacc;
     JComboBox relbox,catbox,incbox,occbox,edubox;
     JCheckBox c1,c2,c3,c4;
     JButton next;
     ButtonGroup b2,b1; 
     JTextField panbox ,adharbox;
     String formno;
     Signuptwo(String n)
    {
        this.formno=n;
//        System.out.println(n);
        setLayout(null);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true); 
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
     
        additionaldetails = new JLabel("Page 2 : Additional Details");
        add(additionaldetails);
        additionaldetails.setBounds(290,70,600,30);
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,20));
        
        religion = new JLabel("Religion:");
        add(religion);
        religion.setBounds(100,130,300,25);
        religion.setFont(new Font("Raleway",Font.BOLD,20));

        String reldetails[]={"Hindu" , "Muslim","Christian","Sikh","others"};
        relbox = new JComboBox(reldetails);
        relbox.setBounds(400,130,350,25);
        add(relbox);
        relbox.setBackground(Color.WHITE);
        
        category = new JLabel("Category:");
        add(category);
       category.setBounds(100,180,300,25);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        
         String catdetails[]={"General" , "OBC","SC","ST","others"};
         catbox = new JComboBox(catdetails);
        catbox.setBounds(400,180,350,25);
        add(catbox);
        catbox.setBackground(Color.WHITE);
        
        income = new JLabel("Income:");
        add(income);
        income.setBounds(100,230,300,25);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        
        String incdetails[]={"null" , "< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
         incbox = new JComboBox(incdetails);
        incbox.setBounds(400,230,350,25);
        add(incbox);
        incbox.setBackground(Color.WHITE);
        
        edu = new JLabel("Educational Qualification:");
        add(edu);
        edu.setBounds(100,290,300,25);
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        
        String edudetails[]={"Graduate" , "Non-Graduate","Post-Graduate","Doctrate","others"};
        edubox = new JComboBox(edudetails);
        edubox.setBounds(400,290,350,25);
        add(edubox);
        edubox.setBackground(Color.WHITE);
        
        occupation = new JLabel("Occupation:");
        add(occupation);
        occupation.setBounds(100,350,300,25);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        
        String occdetails[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occbox = new JComboBox(occdetails);
        occbox.setBounds(400,350,350,25);
        add(occbox);
        occbox.setBackground(Color.WHITE);
        
        adhaar = new JLabel("Adhaar Number:");
        add(adhaar);
        adhaar.setBounds(100,410,300,25);
        adhaar.setFont(new Font("Raleway",Font.BOLD,20));
        
        adharbox = new JTextField();
        adharbox.setBounds(400,410,350,25);
        adharbox.setFont(new Font("Raleway",Font.BOLD,20));
        add(adharbox);
        
        pan = new JLabel("PAN Number:");
        add(pan);
        pan.setBounds(100,480,300,25);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        
        panbox = new JTextField();
         panbox.setBounds(400,480,350,25);
         panbox.setFont(new Font("Raleway",Font.BOLD,20));
        add(panbox);
        
        seniorcitizen = new JLabel("Senior Citizen:");
        add( seniorcitizen );
        seniorcitizen.setBounds(100,540,300,25);
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        
        c1 = new JCheckBox("Yes");
        add(c1);
        c1.setBackground(Color.WHITE);
        c1.setBounds(400,540,100,25);
        c1.setFont(new Font("Raleway",Font.BOLD,20));
        
        c2 = new JCheckBox("No");
        add(c2);
        c2.setBackground(Color.WHITE);
        c2.setBounds(550,540,100,25);
        c2.setFont(new Font("Raleway",Font.BOLD,20));
        
        b1 = new ButtonGroup();
        b1.add(c1);
        b1.add(c2);
        existingacc = new JLabel("Existing Account:");
        add(existingacc);
        existingacc.setBounds(100,600,300,25);
        existingacc.setFont(new Font("Raleway",Font.BOLD,20));
      
        c3 = new JCheckBox("Yes");
        add(c3);
        c3.setBackground(Color.WHITE);
        c3.setBounds(400,600,100,25);
        c3.setFont(new Font("Raleway",Font.BOLD,20));
        
        c4 = new JCheckBox("No");
        add(c4);
        c4.setBackground(Color.WHITE);
        c4.setBounds(550,600,100,25);
        c4.setFont(new Font("Raleway",Font.BOLD,20));
        
        b2 = new ButtonGroup();
        b2.add(c3);
        b2.add(c4);
        
        next = new JButton("Next");
        add(next);
        next.setBounds(650,660,90,30);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        
    }
     @Override
        public void actionPerformed(ActionEvent a)
        {
            String sreligion = (String) relbox.getSelectedItem();
            String scategory = (String) catbox.getSelectedItem();
            String sincome = (String) incbox.getSelectedItem();
            String seducation = (String) edubox.getSelectedItem();
            String soccupation = (String) occbox.getSelectedItem();
            String sadhar = adharbox.getText();
            String span= panbox.getText();
                   
//            use isSelected of radiobutton
            String seniorcitizen = "null";
            if(c1.isSelected()){
                seniorcitizen="yes";
            }else if(c2.isSelected()){
                seniorcitizen="no";
            }
             
            String existingacc="null";
            if(c3.isSelected()){
                existingacc="yes";
            }else if(c4.isSelected()){
                existingacc="no";
            }
            
            try{
                if(sadhar.equals("")){
                  JOptionPane.showMessageDialog(null,"Adhaar is required");   
                }else if(span.equals("")){
                    JOptionPane.showMessageDialog(null,"Pan is required");
                }else if(existingacc=="null"){
                    JOptionPane.showMessageDialog(null,"Select Yes/No for Existing Account");
                }else if(seniorcitizen=="null"){
                    JOptionPane.showMessageDialog(null,"Select Yes/No for Senior Citizen");
                }else{
                    
                    Conn c1 = new Conn();
                    String query = "insert into signuptwo values( '"+formno+"','"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+soccupation+"' , '"+seducation+"' , '"+sadhar+"' , '"+span+"' , '"+seniorcitizen+"' , '"+existingacc+"')";
                    c1.s.executeUpdate(query);
                    
                    if(a.getSource() == next)
                    {
                       setVisible(false);
                       Signupthree s1 = new Signupthree(formno);
                       s1.setVisible(true);
                    }
                }
            }catch(Exception e){
                System.out.print(e);
            }         
       }
  
    public static void main(String args[]) {
        new Signuptwo("");
    }
}
