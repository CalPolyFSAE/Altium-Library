import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class RelayDao {
    private Connection connection;

    public RelayDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Relay relay){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`relays` (`id`, `Name`, `type`, `contactform`, `current`, `voltage`, `flyback`, `mouting`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, relay.getName());
            ps.setString(2, relay.getType());
            ps.setString(3, relay.getContactForm());
            ps.setFloat(4, relay.getCurrent());
            ps.setFloat(5, relay.getVoltage());
            ps.setString(6, relay.getFlyback());
            ps.setString(7, relay.getMounting());
            ps.setString(8, relay.getPackageString());
            ps.setInt(9, relay.getQuantity());
            ps.setString(10, relay.getDescription());
            ps.setString(11, relay.getLibraryRef());
            ps.setString(12, relay.getLibraryPath());
            ps.setString(13, relay.getFootprintRef());
            ps.setString(14, relay.getFootprintPath());
            ps.setString(15, relay.getLink());
            ps.setString(16, DefaultData.name);
            ps.setString(17, DefaultData.name);

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
