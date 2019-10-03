import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IcInterfaceDao {
    private Connection connection;

    public IcInterfaceDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(IcInterface icInterface){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`icinterfaces` (`id`, `name`, `type`, `vcc`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, icInterface.getName());
            ps.setString(2, icInterface.getType());
            ps.setString(3, icInterface.getVcc());
            ps.setString(4, icInterface.getPackageString());
            ps.setInt(5, icInterface.getQuantity());
            ps.setString(6, icInterface.getDescription());
            ps.setString(7, icInterface.getLibraryRef());
            ps.setString(8, icInterface.getLibraryPath());
            ps.setString(9, icInterface.getFootprintRef());
            ps.setString(10, icInterface.getFootprintPath());
            ps.setString(11, icInterface.getLink());
            ps.setString(12, DefaultData.name);
            ps.setString(13, DefaultData.name);

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
