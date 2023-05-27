import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class fee extends JFrame implements ActionListener {
    String x[]={"Roll No","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact No."};
    JButton backbutton;
    JTable table;
    Font f1,f2;

    fee(){
        //frame setup
        super("Due fees");
        this.setVisible(true);
        setLocation(300,200);
        setSize(1400,380);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //parameters setup

        backbutton=new JButton("← Back");
        backbutton.setBounds(600,300,100,30);
        backbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        backbutton.addActionListener(this);

        f1=new Font("Times New Roman",Font.BOLD,18);
        f2=new Font("Times New Roman",Font.BOLD,16);
        backbutton.setFont(f1);

        try {
            connectionclass cc=new connectionclass();

            //firing a query which can take count of total rows and in output only that rows would be printed
            String query1="select count(roll_no) from student where due>0";
            ResultSet rs1=cc.st.executeQuery(query1);
            int count=0;
            
            if(rs1.next()){
                count = rs1.getInt(1);
            }
            String y[][]=new String[count][12];
            int i=0,j=0;
            String query2="select roll_no, name, email, course, fee, paid, due, address, city, state, country, contact from student where due>0";
            ResultSet rs2=cc.st.executeQuery(query2);

            //getting column wise data from database  and storing it in a array(y) like in a form of matrix
            while(rs2.next()){
                y[i][j++]=rs2.getString("roll_no");
                y[i][j++]=rs2.getString("Name");
                y[i][j++]=rs2.getString("email");
                y[i][j++]=rs2.getString("course");
                y[i][j++]=rs2.getString("fee");
                y[i][j++]=rs2.getString("paid");
                y[i][j++]=rs2.getString("due");
                y[i][j++]=rs2.getString("address");
                y[i][j++]=rs2.getString("city");
                y[i][j++]=rs2.getString("state");
                y[i][j++]=rs2.getString("country");
                y[i][j++]=rs2.getString("contact");
                i++;
                j=0;
            }
            DefaultTableModel model = new DefaultTableModel(y, x) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table = new JTable(model);

            //increasing the width of address column to show the entire value
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setPreferredWidth(180);
            table.getColumnModel().getColumn(7).setPreferredWidth(240);
            table.getColumnModel().getColumn(9).setPreferredWidth(170);
            table.getColumnModel().getColumn(11).setPreferredWidth(120);

            //table=new JTable(y,x);
            table.setFont(f2);
            table.setRowHeight(30);

            //user cannot reorder the columns
            table.getTableHeader().setReorderingAllowed(false);

            //the data will be centrally aligned
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for(int a=0;a<12;a++){
                table.getColumnModel().getColumn(a).setCellRenderer(centerRenderer);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane scroll=new JScrollPane(table);
        this.add(backbutton);
        this.add(scroll);
    }
    public void actionPerformed(ActionEvent ee){
        if(ee.getSource()==backbutton){
                new Accountant_section().setVisible(true);
                this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new fee();
    }
}