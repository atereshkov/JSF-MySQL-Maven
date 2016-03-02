package database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    public List<User> getUserList()
    {
        List<User> list = new ArrayList<User>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest?autoReconnect=true&useSSL=true", "root", "root");

            String sql = "select * from users";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next())
            {
                User usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                list.add(usr);
                System.out.println(usr);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }
}