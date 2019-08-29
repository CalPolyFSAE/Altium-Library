import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
public class UserDao {

    private Connection connection;

    public UserDao(Connection connection){
        this.connection = connection;
    }


    public User getUserByUserName(String userName)
    {
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        try
        {
            ps = this.connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, userName);
            resultSet = ps.executeQuery();

            while(resultSet.next()){
                user = new User(
                        userName,
                        resultSet.getString("librarypath"),
                        null,
                        null
                        );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return user;
    }

    public List<String> getUserNames(){
        ArrayList<String> userNames = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        try
        {
            ps = this.connection.prepareStatement("SELECT * FROM users");
            resultSet = ps.executeQuery();

            while(resultSet.next()){
                userNames.add(resultSet.getString("username"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return userNames;
    }

    public Boolean insert(String username){
        Boolean successful = false;
        PreparedStatement ps = null;

        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO users (username, librarypath, createddate, updateddate)"+
                            " VALUES (?,'NA',NOW(), NOW())");
            ps.setString(1, username);
            successful = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return successful;
    }

}
