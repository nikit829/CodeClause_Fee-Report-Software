import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Accountant_section extends JFrame implements ActionListener{
    JLabel l1;
    JButton addstudbutton,viewstudbutton,editstudbutton,duefeebutton,logoutbutton,backbutton;
    Font f1,f2,f3;
    //JPanel p1,p2,p3;

    //default constructor
    Accountant_section(){
        //frame setup
        super("Accountant page");
        setLocation(500,200);
        setSize(400,495);
        setResizable(false);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //fixing label(head)
        l1=new JLabel("Accountant Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(90,5,200,40);

        //fixing button
        addstudbutton=new JButton("Add Student");
        viewstudbutton=new JButton("View Student"); 
        editstudbutton=new JButton("Edit Student"); 
        duefeebutton=new JButton("Due Fees"); 
        logoutbutton=new JButton("Logout");
        backbutton=new JButton("← Back");
        addstudbutton.setBounds(100, 100, 180, 40);
        viewstudbutton.setBounds(100, 160, 180, 40);
        editstudbutton.setBounds(100, 220, 180, 40);
        duefeebutton.setBounds(100, 280, 180, 40);
        logoutbutton.setBounds(116, 340, 150, 40);
        backbutton.setBounds(280,420,100,30);
        addstudbutton.setBackground(Color.LIGHT_GRAY);
        viewstudbutton.setBackground(Color.LIGHT_GRAY);
        editstudbutton.setBackground(Color.LIGHT_GRAY);
        duefeebutton.setBackground(Color.LIGHT_GRAY);
        logoutbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBackground(Color.LIGHT_GRAY);
        addstudbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        viewstudbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        editstudbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        duefeebutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        logoutbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        backbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        addstudbutton.addActionListener(this);
        viewstudbutton.addActionListener(this);
        editstudbutton.addActionListener(this);
        duefeebutton.addActionListener(this);
        logoutbutton.addActionListener(this);
        backbutton.addActionListener(this);

        //working on fonts
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);
        f3=new Font("Times New Roman",Font.BOLD,14);

        l1.setFont(f1);
        addstudbutton.setFont(f2);
        viewstudbutton.setFont(f2);
        editstudbutton.setFont(f2);
        duefeebutton.setFont(f2);
        logoutbutton.setFont(f2);
        backbutton.setFont(f3);

        addstudbutton.setFocusable(false);
        viewstudbutton.setFocusable(false);
        editstudbutton.setFocusable(false);
        duefeebutton.setFocusable(false);
        logoutbutton.setFocusable(false);
        backbutton.setFocusable(false);

        //adding to frame
        this.add(l1);
        this.add(addstudbutton);
        this.add(viewstudbutton);
        this.add(editstudbutton);
        this.add(duefeebutton);
        this.add(logoutbutton);
        this.add(backbutton);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addstudbutton){
            new Add_student().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==viewstudbutton){
            new View_student().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==editstudbutton){
            new Edit_student().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==duefeebutton){
            new fee().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==logoutbutton){
            this.setVisible(false);
        }
        if(e.getSource()==backbutton){
            new Accountant().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Accountant_section();
    }
} 
