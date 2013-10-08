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
    private static final long serialVersionUID = 1L;
    
    private String username;
    
    private String password;
    
    private String employeeid;
    private Connection con;
    private PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
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
    
    //brunthavan
    public boolean check(String userid,String password)
    {
        boolean result=false;
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from employee_data where id='"+userid+"'");

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

    public Login() {
    }

    public Login(String username) {
        this.username = username;
    }

    public Login(String username, String password, String employeeid) {
        this.username = username;
        this.password = password;
        this.employeeid = employeeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SuperMarket.Login[ username=" + username + " ]";
    }
}
