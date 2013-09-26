/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMarket;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Bruntha
 */
public class Login {
    private Connection con;
    private PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
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
    
    public boolean check(String userid,String password)
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
                if(password.equals(rs.getString(2)))
                {
                    JOptionPane.showMessageDialog(null,"Successfull","Error",JOptionPane.ERROR_MESSAGE);
                    result=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong username password","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }    
        return result;
    }
    public boolean usernameValidation(String userid)
    {
        boolean result=true;
        if(userid.length()!=10)
        {
            JOptionPane.showMessageDialog(null,"User id not valid","Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
        return result;
        
    //    else if(!userid.substring(0,4).contains('')
    //    {
      //      JOptionPane.showMessageDialog(null,"User id not valid","Error",JOptionPane.ERROR_MESSAGE);
        //}
    }
    public boolean passwordValidation(String password)
    {
        boolean result=true;
        if(password.length()<8)
        {
            JOptionPane.showMessageDialog(null,"Password not valid","Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
        return result;
    }
    public void onCancel()
    {
        System.exit(0);
    }
    public void onLogin()
    {
        
    }
}
