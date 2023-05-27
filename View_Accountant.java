import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class View_Accountant extends JFrame implements ActionListener {
    String x[]={"Name","Email","Contact no.","Address","ID"};
    JButton backbutton;
    JTable table;
    Font f1,f2;

    View_Accountant(){
        //frame setup
        super("View Accountant");
        this.setVisible(true);
        setLocation(500,200);
        setSize(1000,380);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //parameters setup

        backbutton=new JButton("← Back");
        backbutton.setBounds(440,310,100,30);
        backbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        backbutton.addActionListener(this);

        f1=new Font("Times New Roman",Font.BOLD,18);
        f2=new Font("Times New Roman",Font.BOLD,14);
        backbutton.setFont(f1);

        try {
            connectionclass cc=new connectionclass();

            //firing a query which can take count of total rows and in output only that rows would be printed
            String query1="select count(name) from accountant";
            ResultSet rs1=cc.st.executeQuery(query1);
            int count=0;
            
            if(rs1.next()){
                count = rs1.getInt(1);
            }
            String y[][]=new String[count][5];
            int i=0,j=0;
            String query2="select name, email, contact,address,accountant_id from accountant";
            ResultSet rs2=cc.st.executeQuery(query2);

            //getting column wise data from database  and storing it in a array(y) like in a form of matrix
            while(rs2.next()){
                y[i][j++]=rs2.getString("name");
                y[i][j++]=rs2.getString("email");
                y[i][j++]=rs2.getString("contact");
                y[i][j++]=rs2.getString("address");
                y[i][j++]=rs2.getString("accountant_id");
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
            table.getColumnModel().getColumn(3).setPreferredWidth(200);

            //table=new JTable(y,x);
            table.setFont(f2);
            table.setRowHeight(20);

            //user cannot reorder the columns
            table.getTableHeader().setReorderingAllowed(false);

            //the data will be centrally aligned
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
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
                new AdminSection().setVisible(true);
                this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new View_Accountant();
    }
}