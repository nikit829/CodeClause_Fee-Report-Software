import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_student extends JFrame implements ActionListener {

    //parameters
    JButton addstbutton,resetbutton,cancelbutton;
    JTextField namefield,emailfield,coursefield,feefield,paidfield,duefield,addressfield,cityfield,statefield,countryfield,contactfield;

    Add_student(){

        //frame setup
        super("Add Student");
        this.setVisible(true);
        setLocation(500,200);
        setSize(500,700);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //parameters setup
        
        //working on fonts
        Font f1,f2;
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);
        
        //heading
        JLabel addstulabel=new JLabel("--Add Student--");
        addstulabel.setBounds(160,5,200,50);
        addstulabel.setFont(f1);
        this.add(addstulabel);
        
        //name
        JLabel namelabel= new JLabel("Name:");
        namelabel.setBounds(85,80,200,60);
        namefield = new JTextField();
        namefield.setBounds(180,90,200,30);
        namelabel.setFont(f2);
        this.add(namelabel);
        this.add(namefield);

        //email
        JLabel emaillabel= new JLabel("Email:");
        emaillabel.setBounds(85,120,200,60);
        emailfield = new JTextField();
        emailfield.setBounds(180,130,200,30);
        emaillabel.setFont(f2);
        this.add(emaillabel);
        this.add(emailfield);

        //course
        JLabel courselabel=new JLabel("Course:");
        courselabel.setBounds(85,160,200,60);
        coursefield = new JTextField();
        coursefield.setBounds(180,170,200,30);
        courselabel.setFont(f2);
        this.add(courselabel);
        this.add(coursefield);

        //fee
        JLabel feelabel=new JLabel("Fee");
        feelabel.setBounds(85,200,200,60);
        feefield = new JTextField();
        feefield.setBounds(180,210,200,30);
        feelabel.setFont(f2);
        this.add(feelabel);
        this.add(feefield);

        //paid
        JLabel paidlabel=new JLabel("Paid:");
        paidlabel.setBounds(85,240,200,60);
        paidfield = new JTextField();
        paidfield.setBounds(180,250,200,30);
        paidlabel.setFont(f2);
        this.add(paidlabel);
        this.add(paidfield);
        
        //due
        JLabel duelabel=new JLabel("Due:");
        duelabel.setBounds(85,280,200,60);
        duefield = new JTextField();
        duefield.setBounds(180,290,200,30);
        duelabel.setFont(f2);
        this.add(duelabel);
        this.add(duefield);

        //address
        JLabel addresslabel= new JLabel("Address:");
        addresslabel.setBounds(85,340,200,60);
        addressfield = new JTextField(50);
        addressfield.setBounds(180,330,200,50);
        addresslabel.setFont(f2);
        this.add(addresslabel);
        this.add(addressfield);

        //city
        JLabel citylabel=new JLabel("City:");
        citylabel.setBounds(85,380,200,60);
        cityfield = new JTextField();
        cityfield.setBounds(180,390,200,30);
        citylabel.setFont(f2);
        this.add(citylabel);
        this.add(cityfield);

        //state
        JLabel statelabel=new JLabel("State:");
        statelabel.setBounds(85,420,200,60);
        statefield = new JTextField();
        statefield.setBounds(180,430,200,30);
        statelabel.setFont(f2);
        this.add(statelabel);
        this.add(statefield);
        
        //country
        JLabel countrylabel=new JLabel("Country:");
        countrylabel.setBounds(85,460,200,60);
        countryfield = new JTextField();
        countryfield.setBounds(180,470,200,30);
        countrylabel.setFont(f2);
        this.add(countrylabel);
        this.add(countryfield);
        
        //contact no
        JLabel contactlabel= new JLabel("Contact:");
        contactlabel.setBounds(85,500,200,60);
        contactfield = new JTextField();
        contactfield.setBounds(180,510,200,30);
        contactlabel.setFont(f2);
        this.add(contactlabel);
        this.add(contactfield);
        
        //button
        addstbutton=new JButton("Add");
        resetbutton=new JButton("Reset");
        cancelbutton=new JButton("Cancel");

        addstbutton.setBounds(70,585,100,40);
        resetbutton.setBounds(179,585,100,40);
        cancelbutton.setBounds(288,585,100,40);

        addstbutton.addActionListener(this);
        cancelbutton.addActionListener(this); 
        resetbutton.addActionListener(this); 

        addstbutton.setBackground(Color.LIGHT_GRAY);
        cancelbutton.setBackground(Color.LIGHT_GRAY);
        resetbutton.setBackground(Color.LIGHT_GRAY);

        addstbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancelbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        resetbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        addstbutton.setFocusable(false);
        cancelbutton.setFocusable(false);
        resetbutton.setFocusable(false);

        this.add(addstbutton);
        this.add(cancelbutton);
        this.add(resetbutton);

        addstbutton.setFont(f2);
        cancelbutton.setFont(f2);
        resetbutton.setFont(f2);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addstbutton){
            String name=namefield.getText();
            String email=emailfield.getText();
            String contact=contactfield.getText();
            String course=coursefield.getText();
            String fee=feefield.getText();
            String address=addressfield.getText();
            String paid=paidfield.getText();
            String due=duefield.getText();
            String city=cityfield.getText();
            String state=statefield.getText();
            String country=countryfield.getText();
            try {
                if(name.isEmpty()||email.isEmpty()||contact.isEmpty()||course.isEmpty()||fee.isEmpty()||address.isEmpty()||paid.isEmpty()||due.isEmpty()||city.isEmpty()||state.isEmpty()||country.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Empty Field.\nData not inserted");
                }
                else{
                    connectionclass cc=new connectionclass();
                    String query="insert into student (name, email, course, fee, paid, due, address, city, state, country, contact) values('"+name+"','"+email+"','"+course+"','"+fee+"','"+paid+"','"+due+"','"+address+"','"+city+"','"+state+"','"+country+"','"+contact+"')";
                    int executed= cc.st.executeUpdate(query);
                    if(executed==1){
                        JOptionPane.showMessageDialog(null,"Student added successfully.");
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
            emailfield.setText("");
            contactfield.setText("");
            addressfield.setText("");
            coursefield.setText("");
            feefield.setText("");
            paidfield.setText("");
            duefield.setText("");
            cityfield.setText("");
            statefield.setText("");
            countryfield.setText("");
        }
        if(e.getSource()==cancelbutton){
            new Accountant_section().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Add_student();
    }
}
