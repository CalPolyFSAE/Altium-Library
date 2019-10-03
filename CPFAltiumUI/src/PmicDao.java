import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class PmicDao {

    private Connection connection;

    public PmicDao(Connection connection){
        this.connection = connection;
    }

    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Pmic pmic){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`pmic` (`id`, `name`, `imax`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());\n");
            ps.setString(1, pmic.getName());
            ps.setFloat(2, pmic.getiMax());
            ps.setString(3, pmic.getPackageString());
            ps.setInt(4, pmic.getQuantity());
            ps.setString(5, pmic.getDescription());
            ps.setString(6, pmic.getLibraryRef());
            ps.setString(7, pmic.getLibraryPath());
            ps.setString(8, pmic.getFootprintRef());
            ps.setString(9, pmic.getFootprintPath());
            ps.setString(10, pmic.getLink());
            ps.setString(11, DefaultData.name);
            ps.setString(12, DefaultData.name);

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
