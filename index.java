
//-------------------Fee Report System--------------------//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class index extends JFrame implements ActionListener{
    JLabel l1;
    JButton bt1,bt2;
    Font f1,f2;

    //default constructor
    index(){
        //frame setup
        super("Login");
        setLocation(500,200);
        setSize(400,400);
        setResizable(false);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //fixing label(head)
        l1=new JLabel("Fee Report System");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(100,5,200,60);

        //fixing button
        bt1=new JButton("Admin Login");
        bt2=new JButton("Accountant Login");

        //location of buttons
        bt1.setBounds(100, 120, 200, 60);
        bt2.setBounds(100, 200, 200, 60);

        //designing the buttons
        bt1.setForeground(Color.black);
        bt1.setBackground(Color.LIGHT_GRAY);
        bt2.setForeground(Color.black);
        bt2.setBackground(Color.LIGHT_GRAY);

        bt1.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        bt2.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        //working on fonts
        f1=new Font("Times New Roman",Font.BOLD,22);
        f2=new Font("Times New Roman",Font.BOLD,18);

        //adding font to button
        l1.setFont(f1);
        bt1.setFont(f2);
        bt2.setFont(f2);

        bt1.setFocusable(false);
        bt2.setFocusable(false);

        //adding to frame
        this.add(l1);
        this.add(bt1);
        this.add(bt2);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1){
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==bt2){
            new Accountant().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new index();
    }
} 
