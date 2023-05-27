import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminSection extends JFrame implements ActionListener{
    JLabel l1;
    JButton addaccbutton,viewaccbutton,logoutbutton,backbutton;
    Font f1,f2,f3;
    //JPanel p1,p2,p3;

    //default constructor
    AdminSection(){
        //frame setup
        super("Admin page");
        setLocation(500,200);
        setSize(400,500);
        setResizable(false);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //fixing label(head)
        l1=new JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(90,5,200,40);

        //fixing button
        addaccbutton=new JButton("Add Accountant");
        viewaccbutton=new JButton("View Accountant");
        logoutbutton=new JButton("Logout");
        backbutton=new JButton("← Back");
        addaccbutton.setBounds(100, 120, 180, 50);
        viewaccbutton.setBounds(100, 200, 180, 50);
        logoutbutton.setBounds(115, 280, 150, 50);
        backbutton.setBounds(280,420,100,30);
        addaccbutton.setBackground(Color.LIGHT_GRAY);
        viewaccbutton.setBackground(Color.LIGHT_GRAY);
        logoutbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBackground(Color.LIGHT_GRAY);
        addaccbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        viewaccbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        logoutbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        backbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        addaccbutton.addActionListener(this);
        viewaccbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
        backbutton.addActionListener(this);

        //working on fonts
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);
        f3=new Font("Times New Roman",Font.BOLD,14);

        l1.setFont(f1);
        addaccbutton.setFont(f2);
        viewaccbutton.setFont(f2);
        logoutbutton.setFont(f2);
        backbutton.setFont(f3);

        addaccbutton.setFocusable(false);
        viewaccbutton.setFocusable(false);
        logoutbutton.setFocusable(false);
        backbutton.setFocusable(false);

        //adding to frame
        this.add(l1);
        this.add(addaccbutton);
        this.add(viewaccbutton);
        this.add(logoutbutton);
        this.add(backbutton);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addaccbutton){
            new Add_Accountant().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==viewaccbutton){
            new View_Accountant().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==logoutbutton){
            //new Admin().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==backbutton){
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new AdminSection();
    }
} 
