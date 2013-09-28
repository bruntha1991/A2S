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
    private String customerID;
    GregorianCalendar date = new GregorianCalendar();
    

    public double getPrice() {
        return price;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
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
    public void updateLoyaltyCard(String id,double tot)
    {
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select*from login where Username='"+id+"'");

            if(!(rs.next()))
            {
                JOptionPane.showMessageDialog(null,"No user exist in this id","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               double bal=rs.getDouble(3);
               double last=bal+tot/100;
               
   //            rs.setDouble(3,last);
                          
                
            }
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }
    }
    public void saveCustomerHistory(String id,double tot)
    {
        String dat=date.get(Calendar.YEAR) +"-"+ (date.get(Calendar.MONTH)+1)+ "-"+ date.get(Calendar.DAY_OF_MONTH)+" "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
        try
        {
            ps = con.prepareStatement("INSERT INTO `supermarket_a2s`.`sales_history` (`Date and Time`, `product_id`, `product_name`, `noOfUnits`, `date`, `month`, `year`) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1,dat);
            ps.setString(2, id);
            ps.setDouble(3, tot);
            
            ps.executeUpdate();
        }
        catch(SQLException | HeadlessException e )
        {
            System.out.println(e);
        }
    }
    public void saveHistory()
    {
        String dat=date.get(Calendar.YEAR) +"-"+ (date.get(Calendar.MONTH)+1)+ "-"+ date.get(Calendar.DAY_OF_MONTH)+" "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
                
        try
        {
            ps = con.prepareStatement("INSERT INTO `supermarket_a2s`.`sales_history` (`Date and Time`, `product_id`, `product_name`, `noOfUnits`, `date`, `month`, `year`) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1,dat);
            ps.setString(2, productId);
            ps.setString(3, productname);
            ps.setInt(4, noOfItem);    
            ps.setInt(5,date.get(Calendar.DAY_OF_MONTH));
            ps.setInt(6, (date.get(Calendar.MONTH)+1));
            ps.setInt(7, date.get(Calendar.YEAR));
 //           ps.setString(8,customerID);

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
    
    public boolean productIdValidation(String id)
    {
        boolean result=true;
        
   /*     if(id.length()!=15)
        {
            JOptionPane.showMessageDialog(null, "Lenght should be 15","Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
     */   return result;
    }
    public boolean noOfItemValidation(String no)
    {
        boolean result=true;
        
   /*     if(no.length()!=15)
        {
            JOptionPane.showMessageDialog(null, "Should be greater than 0","Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
     */   return result;
    }

    
    
   
    
}
