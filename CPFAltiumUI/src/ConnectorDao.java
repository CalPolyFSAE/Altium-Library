import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class ConnectorDao {
    private Connection connection;

    public ConnectorDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Connector connector){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`connectors` (`id`, `name`, `numcontacts`, `numrows`, `pitch`, `quantity`, `package`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, connector.getName());
            ps.setInt(2, connector.getNumContacts());
            ps.setInt(3, connector.getNumRows());
            ps.setString(4, connector.getPitch());
            ps.setString(5, connector.getPackageString());
            ps.setInt(6, connector.getQuantity());
            ps.setString(7, connector.getDescription());
            ps.setString(8, connector.getLibraryRef());
            ps.setString(9, connector.getLibraryPath());
            ps.setString(10, connector.getFootprintRef());
            ps.setString(11, connector.getFootprintPath());
            ps.setString(12, connector.getLink());
            ps.setString(13, DefaultData.name);
            ps.setString(14, DefaultData.name);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

}
