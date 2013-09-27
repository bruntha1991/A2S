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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruntha
 */
public class Sales_Add {
    
    private String productId;
    private int noOfItem;
    private String productname;
    private double price;
    private int stockBalance;
    private PreparedStatement ps;
    ResultSet rs;
    Statement st;
    GregorianCalendar date = new GregorianCalendar();
    

    public double getPrice() {
        return price;
    }

    public String getProductname() {
        return productname;
    }

    public int getStockBalance() {
        return stockBalance;
    }
    
    
    
    private Connection con;
    
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
    
    public void saveHistory()
    {
        String dat=date.get(Calendar.YEAR) +"-"+ date.get(Calendar.MONTH)+ "-"+ date.get(Calendar.DAY_OF_MONTH)+" "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
                
        try
        {
            ps = con.prepareStatement("INSERT INTO `supermarket_a2s`.`sales_history` (`No`, `Date and Time`, `product_id`, `product_name`, `noOfUnits`) VALUES (?,?,?,?,?)");

            ps.setString(1,dat);
            ps.setString(2, productId);
            ps.setString(3, productname);
            ps.setInt(4, noOfItem);                

            ps.executeUpdate();
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }
    }
    public boolean checkAvailalitity(String id)
    {
        boolean result=false;
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from product_type where id='"+id+"'");

            if(!(rs.next()))
            {
                JOptionPane.showMessageDialog(null,"Product id not valid","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                productname=rs.getString(2);
                price=rs.getDouble(3);
                stockBalance=rs.getInt(4);
                result=true;
            }
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }    
        return result;
    }
    public void onOK()
    {
        
    }
    public void onCancel()
    {
        
    }
    public boolean productIdValidation(String pi)
    {
        boolean result=true;
        
        //validation 
        
        return result;
    }
    public boolean noOfItemValidation(String no)
    {
        boolean result=true;
        
        //validation 
        
        return result;
    }
    public void setProductId(String pi)
    {
        productId=pi;
    }
    public void setNoOfItem(int no)
    {
        noOfItem=no;
    }
    public String getProductId()
    {
        return productId;
    }
    public int getNoOfItem()
    {
        return noOfItem;
    }
    /*  vinojan fill this
    public boolean productIdValidation()
    {
        
    }
    public boolean noOfItemValidation()
    {
        
    }
*/
    
    
   
    
}
