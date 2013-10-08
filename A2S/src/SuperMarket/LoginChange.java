/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMarket;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruntha
 */
public class LoginChange {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public void connectDB() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","");
        }
        catch(ClassNotFoundException | SQLException e )
        {
            System.out.println(e);
        }
    }
    
    public boolean check(String userid,String o_pword,String n_pword)
    {
        boolean result=false;
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from login where Username='"+userid+"'");

            if(!(rs.next()))
            {
                JOptionPane.showMessageDialog(null,"No user exist in this id","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(o_pword.equals(rs.getString(2)))
                {
                    ps = con.prepareStatement("Update employee_data Set password='"+n_pword+"'Where id='"+userid+"'");
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Successfully changed","DD",JOptionPane.INFORMATION_MESSAGE);
                    result=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong username password combination","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }    
        return result;
    }
    
}
