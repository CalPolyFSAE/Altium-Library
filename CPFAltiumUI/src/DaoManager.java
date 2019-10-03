import javax.security.auth.login.CredentialException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.io.File;
import java.util.Scanner;

public class DaoManager {

    private String user;
    private String pass;
    private String driver;
    private String hostname;
    private Connection connection;

    public DaoManager(){
        this.user = DefaultData.sqlusername;
        this.pass = DefaultData.password;
        this.hostname = DefaultData.hostname;
        this.driver = DefaultData.driver;
    }

    public Connection getConnection(){
        try {
            if (this.connection == null || this.connection.isClosed())
                setupConnection();
            return connection;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private void setupConnection() throws Exception{
        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.hostname, this.user, this.pass);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Connection Setup Failed");
        }
    }

    public int close() {
        try
        {
            if(this.connection != null && !this.connection.isClosed())
                this.connection.close();
            return 1;
        }
        catch(SQLException e)
        {
            System.out.println("Message to server failed please try again 1");
            return -1;
        }
    }

    public int setAutoCommitTrue(){
        try {
            this.connection.setAutoCommit(true);
            return 1;
        }catch (Exception e){
            System.out.println("Setting auto commit true failed");
            return -1;
        }
    }

    public int setAutoCommitFalse(){
        try {
            this.connection.setAutoCommit(false);
            return 1;
        }catch (Exception e){
            System.out.println("Setting auto commit false failed");
            return -1;
        }
    }

    public int commitChanges(){
        try {
            this.connection.commit();
            return 1;
        }catch (Exception e){
            System.out.println("Message to server failed please try again 4");
            return -1;
        }
    }

    public int rollbackChanges(){
        try {
            this.connection.rollback();
            return 1;
        }catch (Exception e){
            System.out.println("Message to server failed please try again 5");
            return -1;
        }
    }

    public BjtDao getBjtDao(){
        getConnection();
        return new BjtDao(this.connection);
    }

    public UserDao getUserDao(){
        getConnection();
        return new UserDao(this.connection);
    }

    public CapacitorDao getCapacitorDao(){
        getConnection();
        return new CapacitorDao(this.connection);
    }

    public ResistorDao getResistorDao(){
        getConnection();
        return new ResistorDao(this.connection);
    }

    public DiodeDao getDiodeDao(){
        getConnection();
        return new DiodeDao(this.connection);
    }

    public FetDao getFetDao(){
        getConnection();
        return new FetDao(this.connection);
    }

    public PmicDao getPmicDao(){
        getConnection();
        return new PmicDao(this.connection);
    }

    public FuseDao getFuseDao(){
        getConnection();
        return new FuseDao(this.connection);
    }

    public IcMiscDao getIcMiscDao(){
        getConnection();
        return new IcMiscDao(this.connection);
    }

    public ConnectorDao getConnectorDao(){
        getConnection();
        return new ConnectorDao(this.connection);
    }
    public IcInterfaceDao getIcInterfaceDao(){
        getConnection();
        return new IcInterfaceDao(this.connection);
    }
    public InductorDao getInductorDao(){
        getConnection();
        return new InductorDao(this.connection);
    }

    public RelayDao getRelayDao(){
        getConnection();
        return new RelayDao(this.connection);
    }

}
