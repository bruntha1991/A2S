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
    String[][] data=new String[10][4];
    
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
    public void getDetails()
    {
        if(year!=0 &&month==0 && day==0)
        {
            
        }
        else if(year!=0 && month!=0 && day==0)
        {
            
        }
        else
        {
            
        }
    }
}
