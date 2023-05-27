import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Accountant extends JFrame implements ActionListener{

    //parameters
    JButton loginbutton,resetbutton,backbutton;
    JTextField userfield,passwordfield;

    Accountant(){
        //frame setup
        super("Accountant");
        this.setVisible(true);
        setLocation(500,200);
        setSize(400,400);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //parameters setup
        //JFrame frame=new JFrame();
        loginbutton=new JButton("Login");
        resetbutton=new JButton("Reset");
        backbutton=new JButton("← Back");
        userfield=new JTextField();
        passwordfield=new JPasswordField();
        JLabel adminloginlabel=new JLabel("Accountant Login");
        JLabel usernamelabel= new JLabel("Username: ");
        JLabel passwordlabel= new JLabel("Password: ");
        
        adminloginlabel.setBounds(110,5,200,60);
        usernamelabel.setBounds(40,100,200,60);
        passwordlabel.setBounds(40,150,200,60);
        userfield.setBounds(135,110,180,40);
        passwordfield.setBounds(135,160,180,40);
        loginbutton.setBounds(87,260,100,40);
        resetbutton.setBounds(193,260,100,40);
        backbutton.setBounds(280,330,100,30);

        //fixing buttons
        loginbutton.addActionListener(this);
        resetbutton.addActionListener(this); 
        backbutton.addActionListener(this); 
        loginbutton.setBackground(Color.LIGHT_GRAY);
        resetbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBackground(Color.lightGray);
        loginbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        resetbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        backbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        //working on fonts
        Font f1,f2,f3;
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);
        f3=new Font("Times New Roman",Font.BOLD,14);
        adminloginlabel.setFont(f1);
        usernamelabel.setFont(f2);
        passwordlabel.setFont(f2);
        loginbutton.setFont(f2);
        resetbutton.setFont(f2);
        backbutton.setFont(f3);

        loginbutton.setFocusable(false);
        resetbutton.setFocusable(false);

        //adding to frame
        this.add(adminloginlabel);
        this.add(usernamelabel);
        this.add(passwordlabel);
        this.add(userfield);
        this.add(passwordfield);
        this.add(loginbutton);
        this.add(resetbutton);
        this.add(backbutton);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resetbutton){
            userfield.setText("");
            passwordfield.setText("");
        }

        String username=userfield.getText();
        String password=passwordfield.getText();
        
        if(e.getSource()==loginbutton){
            try {
                connectionclass cc=new connectionclass();
                String query="select * from accountant where name='"+username+"' and password='"+password+"'";
                ResultSet rs=cc.st.executeQuery(query);
                if(rs.next()){
                    new Accountant_section().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Username or password error.");
                }

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==backbutton){
            new index().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Accountant();
    }
}
