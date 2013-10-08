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

    public Report() {
        
        data[0]=new ArrayList<>();
	data[1]=new ArrayList<>();
        data[2]=new ArrayList<>();
	data[3]=new ArrayList<>();
        
    }
    
    
    public void setDate(int year,int month,int day)
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
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket_a2s","root","");
        }
        catch(ClassNotFoundException | SQLException e )
        {
            System.out.println(e);
        }
    }
    public void printDetails(javax.swing.JTable table)
    {
  //      System.out.println(data[0].size());
        for(int i=0;i<data[0].size();i++)
        {
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{data[0].get(i),data[1].get(i),data[2].get(i), data[3].get(i)});  
        }
    }
    public void getDetails() 
    {
        try
        {
            if(year!=0 &&month==0 && day==0)
            {
                st=con.createStatement();
                rs=st.executeQuery("select*from sales_history where year='"+year+2012+"'");

                while(rs.next())
                {
                    if(!data[0].contains(rs.getString(2)))
                    {
                        data[0].add(rs.getString(2));
                        data[1].add(rs.getString(3));
                        data[2].add(String.valueOf(rs.getInt(4)));
                        data[3].add(rs.getString(2));
                    }
                    else
                    {
                        int index=data[0].indexOf(rs.getString(2));
                        int val=rs.getInt(4);
                        int val1=Integer.parseInt(data[2].get(index));
                        data[2].set(index, String.valueOf(val+val1));         

          //              data[].remove(index)

                    }
                }
            }
            else if(year!=0 && month!=0 && day==0)
            {
                st=con.createStatement();
                rs=st.executeQuery("select*from sales_history where year='"+year+2012+"'AND month='"+month+"'");

                while(rs.next())
                {
                    if(!data[0].contains(rs.getString(2)))
                    {
                        data[0].add(rs.getString(2));
                        data[1].add(rs.getString(3));
                        data[2].add(String.valueOf(rs.getInt(4)));
                        data[3].add(rs.getString(2));
                    }
                    else
                    {
                        int index=data[0].indexOf(rs.getString(2));
                        int val=rs.getInt(4);
                        int val1=Integer.parseInt(data[2].get(index));
                        data[2].set(index, String.valueOf(val+val1));         

          //              data[].remove(index)

                    }
                }
            }
            else
            {
                System.out.println(year+" "+month+" "+day);
                st=con.createStatement();
                rs=st.executeQuery("select * from sales_history where year='"+(year+2012)+"'AND month='"+month+"' AND date='"+day+"'");

                while(rs.next())
                {
                    if(!data[0].contains(rs.getString(2)))
                    {
                        data[0].add(rs.getString(2));
                        data[1].add(rs.getString(3));
                        data[2].add(String.valueOf(rs.getInt(4)));
                        data[3].add(rs.getString(2));
                    }
                    else
                    {
                        int index=data[0].indexOf(rs.getString(2));
                        int val=rs.getInt(4);
                        int val1=Integer.parseInt(data[2].get(index));
                        data[2].set(index, String.valueOf(val+val1));         

          //              data[].remove(index)

                    }
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e);
        }
    }
    
}
