import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Edit_student extends JFrame implements ActionListener {

    //parameters
    JButton loadrecbutton,updatestbutton,resetbutton,cancelbutton;
    JTextField rollnofield,namefield,emailfield,coursefield,feefield,paidfield,duefield,addressfield,cityfield,statefield,countryfield,contactfield;

    Edit_student(){

        //frame setup
        super("Edit Student");
        this.setVisible(true);
        setLocation(500,200);
        setSize(550,800);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //parameters setup
        
        //working on fonts
        Font f1,f2;
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);
        
        //heading
        JLabel addstulabel=new JLabel("--Edit Student--");
        addstulabel.setBounds(185,5,200,60);
        addstulabel.setFont(f1);
        this.add(addstulabel);
        
        //roll no
        JLabel rollnolabel= new JLabel("Roll no.:");
        rollnolabel.setBounds(110,85,200,60);
        rollnofield = new JTextField();
        rollnofield.setBounds(215,100,80,30);
        rollnolabel.setFont(f2);
        this.add(rollnolabel);
        this.add(rollnofield);

        //horizontal line
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(20,150,495,20);
        separator.setForeground(Color.BLACK);
        this.add(separator);

        //name
        JLabel namelabel= new JLabel("Name:");
        namelabel.setBounds(110,160,200,60);
        namefield = new JTextField();
        namefield.setBounds(215,170,200,30);
        namelabel.setFont(f2);
        this.add(namelabel);
        this.add(namefield);

        //email
        JLabel emaillabel= new JLabel("Email:");
        emaillabel.setBounds(110,200,200,60);
        emailfield = new JTextField();
        emailfield.setBounds(215,210,200,30);
        emaillabel.setFont(f2);
        this.add(emaillabel);
        this.add(emailfield);

        //course
        JLabel courselabel=new JLabel("Course:");
        courselabel.setBounds(110,240,200,60);
        coursefield = new JTextField();
        coursefield.setBounds(215,250,200,30);
        courselabel.setFont(f2);
        this.add(courselabel);
        this.add(coursefield);

        //fee
        JLabel feelabel=new JLabel("Fee");
        feelabel.setBounds(110,280,200,60);
        feefield = new JTextField();
        feefield.setBounds(215,290,200,30);
        feelabel.setFont(f2);
        this.add(feelabel);
        this.add(feefield);

        //paid
        JLabel paidlabel=new JLabel("Paid:");
        paidlabel.setBounds(110,320,200,60);
        paidfield = new JTextField();
        paidfield.setBounds(215,330,200,30);
        paidlabel.setFont(f2);
        this.add(paidlabel);
        this.add(paidfield);
        
        //due
        JLabel duelabel=new JLabel("Due:");
        duelabel.setBounds(110,360,200,60);
        duefield = new JTextField();
        duefield.setBounds(215,370,200,30);
        duelabel.setFont(f2);
        this.add(duelabel);
        this.add(duefield);

        //address
        JLabel addresslabel= new JLabel("Address:");
        addresslabel.setBounds(110,420,200,60);
        addressfield = new JTextField(50);
        addressfield.setBounds(215,410,200,50);
        addresslabel.setFont(f2);
        this.add(addresslabel);
        this.add(addressfield);

        //city
        JLabel citylabel=new JLabel("City:");
        citylabel.setBounds(110,460,200,60);
        cityfield = new JTextField();
        cityfield.setBounds(215,470,200,30);
        citylabel.setFont(f2);
        this.add(citylabel);
        this.add(cityfield);

        //state
        JLabel statelabel=new JLabel("State:");
        statelabel.setBounds(110,500,200,60);
        statefield = new JTextField();
        statefield.setBounds(215,510,200,30);
        statelabel.setFont(f2);
        this.add(statelabel);
        this.add(statefield);
        
        //country
        JLabel countrylabel=new JLabel("Country:");
        countrylabel.setBounds(110,540,200,60);
        countryfield = new JTextField();
        countryfield.setBounds(215,550,200,30);
        countrylabel.setFont(f2);
        this.add(countrylabel);
        this.add(countryfield);
        
        //contact no
        JLabel contactlabel= new JLabel("Contact:");
        contactlabel.setBounds(110,580,200,60);
        contactfield = new JTextField();
        contactfield.setBounds(215,590,200,30);
        contactlabel.setFont(f2);
        this.add(contactlabel);
        this.add(contactfield);
        
        //button
        loadrecbutton=new JButton("Load Record");
        updatestbutton=new JButton("Update");
        resetbutton=new JButton("Reset");
        cancelbutton=new JButton("Cancel");

        loadrecbutton.setBounds(350,100,120,40);
        updatestbutton.setBounds(105,680,100,40);
        resetbutton.setBounds(214,680,100,40);
        cancelbutton.setBounds(323,680,100,40);

        loadrecbutton.addActionListener(this);
        updatestbutton.addActionListener(this);
        cancelbutton.addActionListener(this); 
        resetbutton.addActionListener(this); 

        loadrecbutton.setBackground(Color.LIGHT_GRAY);
        updatestbutton.setBackground(Color.LIGHT_GRAY);
        cancelbutton.setBackground(Color.LIGHT_GRAY);
        resetbutton.setBackground(Color.LIGHT_GRAY);

        loadrecbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        updatestbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        cancelbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        resetbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        loadrecbutton.setFocusable(false);
        updatestbutton.setFocusable(false);
        cancelbutton.setFocusable(false);
        resetbutton.setFocusable(false);

        this.add(loadrecbutton);
        this.add(updatestbutton);
        this.add(cancelbutton);
        this.add(resetbutton);

        loadrecbutton.setFont(f2);
        updatestbutton.setFont(f2);
        cancelbutton.setFont(f2);
        resetbutton.setFont(f2);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loadrecbutton){
            // Get the roll number entered by the user
            String rollno = rollnofield.getText();

            // Check if the roll number field is empty
            if (rollno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a roll number.");
                return;
            }
            try {
                // Create a new connection to the database
            connectionclass cc = new connectionclass();

            // Create a SELECT statement to query the student record with the specified roll number
            String query = "SELECT * FROM student WHERE roll_no = '"+rollno+"'";

            // Execute the query and get the result set
            ResultSet rs = cc.st.executeQuery(query);

            // Check if a record was found
            if (rs.next()) {
                // Get the values from the result set and set them in the text fields
                namefield.setText(rs.getString("name"));
                emailfield.setText(rs.getString("email"));
                coursefield.setText(rs.getString("course"));
                feefield.setText(rs.getString("fee"));
                paidfield.setText(rs.getString("paid"));
                duefield.setText(rs.getString("due"));
                addressfield.setText(rs.getString("address"));
                cityfield.setText(rs.getString("city"));
                statefield.setText(rs.getString("state"));
                countryfield.setText(rs.getString("country"));
                contactfield.setText(rs.getString("contact"));
            } else {
                // No record was found, show an error message
                JOptionPane.showMessageDialog(null, "No student found with the specified roll number.");
            }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

        if(e.getSource()==updatestbutton){
            String rollno=rollnofield.getText();
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
                    if (rollno.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a roll number.");
                        return;
                    }
                    else{
                        //JOptionPane.showMessageDialog(null,"Data Filled.");
                        connectionclass cc=new connectionclass();
                        String query="UPDATE student SET Name = '"+name+"', email='"+email+"', contact='"+contact+"', course='"+course+"', fee='"+fee+"', address='"+address+"', paid='"+paid+"', due='"+due+"', city='"+city+"', state='"+state+"', country='"+country+"' WHERE roll_no = '"+rollno+"'";
                        int executed= cc.st.executeUpdate(query);
                        if(executed==1){
                            JOptionPane.showMessageDialog(null,"Student updated successfully.");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Data not inserted.");
                        }
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
        new Edit_student();
    }
}
