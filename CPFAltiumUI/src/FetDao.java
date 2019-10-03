import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class FetDao {
        private Connection connection;

    public FetDao(Connection connection){
        this.connection = connection;
    }

    public Set<Bjt> getAll(){
    return null;
    }

    public int insert(Fet fet){;
    int ret = -1;
    PreparedStatement ps = null;
    try {
        ps = this.connection.prepareStatement(
                "INSERT INTO `cpf_altium`.`fets` (`id`, `name`, `type`, `vdsmax`, `numcircuits`, `current`, `rdson`, `vt`, `vgsmax`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                        " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
        ps.setString(1, fet.getName());
        ps.setString(2, fet.getType());
        ps.setFloat(3, fet.getVdsmax());
        ps.setInt(4, fet.getNumcircuits());
        ps.setFloat(5, fet.getCurrent());
        ps.setString(6, fet.getRdson());
        ps.setFloat(7, fet.getVt());
        ps.setFloat(8, fet.getVgsmax());
        ps.setString(10, fet.getPackageString());
        ps.setFloat(9, fet.getQuantity());
        ps.setString(11, fet.getDescription());
        ps.setString(12, fet.getLibraryRef());
        ps.setString(13, fet.getLibraryPath());
        ps.setString(14, fet.getFootprintRef());
        ps.setString(15, fet.getFootprintPath());
        ps.setString(16, fet.getLink());
        ps.setString(17, DefaultData.name);
        ps.setString(18, DefaultData.name);

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
