/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruntha
 */
public class Report {
    
    private Connection con;
    private PreparedStatement ps;
    ResultSet rs;
    Statement st;
    int year;
    int month;
    int day;
//    String[][] data=new String[10][4];
    ArrayList<String>[] data=new ArrayList[4];
    
    Report(int year,int month,int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    
    public void connectDB() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarker_a2s","root","");
        }
        catch(ClassNotFoundException | SQLException e )
        {
            System.out.println(e);
        }
    }
    public void printDetails(javax.swing.JTable table)
    {
        for(int i=0;i<data[0].size();i++)
        {
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{data[0].get(i),data[1].get(i),data[2].get(i), data[3].get(i)});  
        }
    }
    public void getDetails() throws SQLException
    {
        if(year!=0 &&month==0 && day==0)
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from sales_history where year='"+year+"'");

            while(rs.next())
            {
                if(!data[0].contains(rs.getString(1)))
                {
                    data[0].add(rs.getString(1));
                    data[1].add(rs.getString(2));
                    data[2].add(rs.getString(3));
                    data[3].add(rs.getString(4));
                }
                else
                {
                    int index=data[0].indexOf(rs.getString(1));
                    int val=rs.getInt(4);
                    int val1=Integer.parseInt(data[3].get(index));
                    data[3].set(index, String.valueOf(val+val1));         
                    
      //              data[].remove(index)
                    
                }
            }
        }
        else if(year!=0 && month!=0 && day==0)
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from sales_history where year='"+year+"'AND month='"+month+"'");

            while(rs.next())
            {
                if(!data[0].contains(rs.getString(1)))
                {
                    data[0].add(rs.getString(1));
                    data[1].add(rs.getString(2));
                    data[2].add(rs.getString(3));
                    data[3].add(rs.getString(4));
                }
                else
                {
                    int index=data[0].indexOf(rs.getString(1));
                    int val=rs.getInt(4);
                    int val1=Integer.parseInt(data[3].get(index));
                    data[3].set(index, String.valueOf(val+val1));         
                    
      //              data[].remove(index)
                    
                }
            }
        }
        else
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from sales_history where year='"+year+"'AND month='"+month+"' AND day='"+day+"'");

            while(rs.next())
            {
                if(!data[0].contains(rs.getString(1)))
                {
                    data[0].add(rs.getString(1));
                    data[1].add(rs.getString(2));
                    data[2].add(rs.getString(3));
                    data[3].add(rs.getString(4));
                }
                else
                {
                    int index=data[0].indexOf(rs.getString(1));
                    int val=rs.getInt(4);
                    int val1=Integer.parseInt(data[3].get(index));
                    data[3].set(index, String.valueOf(val+val1));         
                    
      //              data[].remove(index)
                    
                }
            }
        }
    }
    
}
