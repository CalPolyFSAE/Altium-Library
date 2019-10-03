import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class InductorDao {
    private Connection connection;

    public InductorDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Inductor inductor){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`inductors` (`id`, `name`, `inductance`, `imax`, `tolerance`, `resistance`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, inductor.getName());
            ps.setString(2, inductor.getInductance());
            ps.setFloat(3, inductor.getiMax());
            ps.setFloat(4, inductor.getTolerance());
            ps.setString(5, inductor.getResistance());
            ps.setString(6, inductor.getPackageString());
            ps.setInt(7, inductor.getQuantity());
            ps.setString(8, inductor.getDescription());
            ps.setString(9, inductor.getLibraryRef());
            ps.setString(10, inductor.getLibraryPath());
            ps.setString(11, inductor.getFootprintRef());
            ps.setString(12, inductor.getFootprintPath());
            ps.setString(13, inductor.getLink());
            ps.setString(14, DefaultData.name);
            ps.setString(15, DefaultData.name);

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
