import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class FuseDao {
    private Connection connection;

    public FuseDao(Connection connection){
        this.connection = connection;
    }

    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Fuse fuse){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`fuses` (`id`, `Name`, `itrip`, `iinterrupt`, `vmax`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, fuse.getName());
            ps.setFloat(2, fuse.getiTrip());
            ps.setFloat(3, fuse.getiInterupt());
            ps.setFloat(4, fuse.getvMax());
            ps.setInt(5, fuse.getQuantity());
            ps.setString(6, fuse.getDescription());
            ps.setString(7, fuse.getLibraryRef());
            ps.setString(8, fuse.getLibraryPath());
            ps.setString(9, fuse.getFootprintRef());
            ps.setString(10, fuse.getFootprintPath());
            ps.setString(11, fuse.getLink());
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
