import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_Accountant extends JFrame implements ActionListener {

    //parameters
    JButton addbutton,resetbutton,cancelbutton;
    JTextField namefield,emailfield,contactfield,Idfield,addressfield,passwordfield;

    Add_Accountant(){

        //frame setup
        super("Add accountant");
        this.setVisible(true);
        setLocation(500,200);
        setSize(500,620);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //parameters setup

        addbutton=new JButton("Add");
        cancelbutton=new JButton("Cancel");
        resetbutton=new JButton("Reset");
    
        JLabel addacclabel=new JLabel("--Add Accountant--");
        JLabel namelabel= new JLabel("Name:");
        JLabel passwordlabel= new JLabel("Password:");
        JLabel emaillabel= new JLabel("Email:");
        JLabel contactlabel= new JLabel("Contact:");
        JLabel addresslabel= new JLabel("Address:");
        JLabel Idlabel= new JLabel("Accountant ID:");
        
        addacclabel.setBounds(150,5,200,60);
        namelabel.setBounds(65,107,200,60);
        passwordlabel.setBounds(65,157,200,60);
        emaillabel.setBounds(65,207,200,60);
        contactlabel.setBounds(65,257,200,60);
        addresslabel.setBounds(65,307,200,60);
        Idlabel.setBounds(65,357,200,60);

        namefield = new JTextField();
        passwordfield = new JPasswordField();
        emailfield = new JTextField();
        contactfield = new JTextField();
        addressfield = new JTextField();
        Idfield = new JTextField();

        namefield.setBounds(220,117,180,40);
        passwordfield.setBounds(220,167,180,40);
        emailfield.setBounds(220,217,180,40);
        contactfield.setBounds(220,267,180,40);
        addressfield.setBounds(220,317,180,40);
        Idfield.setBounds(220,367,180,40);
        
        //fixing buttons
        addbutton.setBounds(70,470,100,40);
        resetbutton.setBounds(179,470,100,40);
        cancelbutton.setBounds(288,470,100,40);
        addbutton.addActionListener(this);
        cancelbutton.addActionListener(this); 
        resetbutton.addActionListener(this); 
        addbutton.setBackground(Color.LIGHT_GRAY);
        cancelbutton.setBackground(Color.LIGHT_GRAY);
        resetbutton.setBackground(Color.LIGHT_GRAY);
        addbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancelbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        resetbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        addbutton.setFocusable(false);
        cancelbutton.setFocusable(false);
        resetbutton.setFocusable(false);

        //working on fonts
        Font f1,f2;
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);

        addacclabel.setFont(f1);
        namelabel.setFont(f2);
        passwordlabel.setFont(f2);
        emaillabel.setFont(f2);
        contactlabel.setFont(f2);
        addresslabel.setFont(f2);
        Idlabel.setFont(f2);

        addbutton.setFont(f2);
        cancelbutton.setFont(f2);
        resetbutton.setFont(f2);

        //adding to frame
        this.add(addacclabel);
        this.add(namelabel);
        this.add(passwordlabel);
        this.add(emaillabel);
        this.add(contactlabel);
        this.add(addresslabel);
        this.add(Idlabel);

        this.add(namefield);
        this.add(passwordfield);
        this.add(emailfield);
        this.add(contactfield);
        this.add(addressfield);
        this.add(Idfield);

        this.add(addbutton);
        this.add(cancelbutton);
        this.add(resetbutton);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addbutton){
            String name=namefield.getText();
            String password=passwordfield.getText();
            String email=emailfield.getText();
            String contact=contactfield.getText();
            String address=addressfield.getText();
            String accId=Idfield.getText();
            try {
                if(name.isEmpty()||password.isEmpty()||contact.isEmpty()||accId.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Empty Field.\nInsert data.");
                }
                else{
                    connectionclass cc=new connectionclass();
                    String query="insert into accountant values('"+name+"','"+password+"','"+email+"','"+contact+"','"+address+"','"+accId+"')";
                    int executed= cc.st.executeUpdate(query);
                    if(executed==1){
                        JOptionPane.showMessageDialog(null,"Accountant successfully added.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Data not inserted.");
                    }
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==resetbutton){
            namefield.setText("");
            passwordfield.setText("");
            emailfield.setText("");
            contactfield.setText("");
            addressfield.setText("");
            Idfield.setText("");
        }
        if(e.getSource()==cancelbutton){
            new AdminSection().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Add_Accountant();
    }
}
