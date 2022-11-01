package Employee;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class sam_payroll extends JFrame implements ActionListener {


    JLabel lbl=new JLabel(" Payroll System Version 2.0");

    Font f=new Font("Times",Font.BOLD,30);
    Font f1=new Font("Times",Font.BOLD,16);
    Font f2=new Font("Times",Font.BOLD,12);

    JLabel lblid,lblname,lbldepartment,lbldays,lblrate,lblsubmit;
    JLabel lblsalary;
    JTextField txtid,txtname,txtdepartment,txtdays;
    JTextField txtrate,txtsalary;
    JRadioButton rbmale,rbfemale;
    JButton btnadd,btnsave,btnupdate,btndelete,btnexit;
    JButton btnnext,btnprev,btnlast,btnfirst;
    JButton btncompute;
    String gen;
    ResultSet rs=null;


    float days,rate,salary;

    sam_payroll()
    {

        super("Employees Information ");
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

        setLayout(null);

        add(lblsubmit);
        lblsubmit.setHorizontalAlignment(lblsubmit.CENTER );
        lblsubmit.setBounds(220,510,450,20);
        lblsubmit.setFont(f1);


        add(lbl);


        lbl.setBounds(200,50,500,100);
        lbl.setHorizontalAlignment(lbl.CENTER );

        lbl.setFont(f);



        lblid=new JLabel("ID");
        lblname=new JLabel("NAME");
        lbldepartment=new JLabel("DEPARTMENT");
        lbldays=new JLabel("N0. OF DAYS ");
        lblrate=new JLabel("RATE PER DAY");
        lblsalary=new JLabel("SALARY");

        lblid.setBounds(300,140,100,20);
        lblname.setBounds(300,180,100,20);
        lbldepartment.setBounds(300,220,100,20);
        lbldays.setBounds(300,250,100,20);
        lblrate.setBounds(300,280,100,20);
        lblsalary.setBounds(300,310,100,20);


        add(lblid);
        add(lblname);
        add(lbldepartment);
        add(lbldays);
        add(lblrate);
        add(lblsalary);


        lblid.setFont(f2);
        lblname.setFont(f2);
        lbldepartment.setFont(f2);
        lbldays.setFont(f2);
        lblrate.setFont(f2);
        lblsalary.setFont(f2);


        txtid=new JTextField(15);
        txtname=new JTextField(15);
        txtdepartment=new JTextField(15);
        txtdays=new JTextField(15);
        txtrate=new JTextField(15);
        txtsalary=new JTextField(15);



        txtid.setBounds(400,140,100,20);
        txtname.setBounds(400,180,100,20);
        txtdepartment.setBounds(400,220,100,20);
        txtdays.setBounds(400,250,100,20);
        txtrate.setBounds(400,280,100,20);
        txtsalary.setBounds(400,310,100,20);



        add(txtid);
        add(txtname);
        add(txtdepartment);
        add(txtdays);
        add(txtrate);
        add(txtsalary);


        btnfirst=new JButton("First");
        btnnext=new JButton("Next");
        btnprev=new JButton("Previous");
        btnlast=new JButton("Last");


        btnfirst.setToolTipText("Click this button to move to the First Record.");
        btnnext.setToolTipText("Click this button to move to the Next Record.");
        btnprev.setToolTipText("Click this button to move to the Previous Record.");
        btnlast.setToolTipText("Click this button to move to the Last Record.");



        btnfirst.setBounds(200,440,100,30);
        btnnext.setBounds(310,440,100,30);
        btnprev.setBounds(420,440,100,30);
        btnlast.setBounds(530,440,100,30);


        add(btnfirst);
        add(btnnext);
        add(btnprev);
        add(btnlast);


        btnfirst.addActionListener(this);
        btnnext.addActionListener(this);
        btnprev.addActionListener(this);
        btnlast.addActionListener(this);

        btnexit=new JButton("Exit");
        btnexit.setToolTipText("Click this button to Quit Program.");
        btnexit.setBounds(360,480,100,30);
        add(btnexit);
        btnexit.addActionListener(this);

        btncompute=new JButton("Compute");
        btncompute.setToolTipText("Click this button to compute the salary of the employee.");
        btncompute.setBounds(360,350,100,30);
        add(btncompute);
        btncompute.addActionListener(this);

    }


    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(ae.getActionCommand()=="Compute")
            {

                days=Float.parseFloat(txtdays.getText());
                rate=Float.parseFloat(txtrate.getText());
                salary=(days*rate);
                float round = Round(salary,2);
                txtsalary.setText(Float.toString(round));
                txtsalary.setEditable(false);
            }
            if(ae.getActionCommand()=="Exit")
            {
                System.exit(0);
            }



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }





    public static float Round(float Rval, int Rpl) {
        float p = (float)Math.pow(10,Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float)tmp/p;
    }


    public void setText(){
        try{
            txtid.setText(rs.getString(1));
            txtname.setText(rs.getString(2));
            txtdepartment.setText(rs.getString(3));
            txtdays.setText(rs.getString(4));
            txtrate.setText(rs.getString(5));
            txtsalary.setText(rs.getString(6));

        }catch(Exception ex){}
    }
}




public class Employee_Pay
{
    public static void main(String ar[])throws Exception
    {

        sam_payroll f1=new sam_payroll();

        f1.setSize(800,600);

        f1.setVisible(true);

    }
}


