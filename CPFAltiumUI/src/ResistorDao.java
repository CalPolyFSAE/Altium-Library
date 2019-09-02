import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class ResistorDao {
    private Connection connection;

    public ResistorDao(Connection connection){
        this.connection = connection;
    }

    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Resistor resistor){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`resistors` (`id`, `name`, `resistance`, `percent tolerance`, `power`, `package`, `quantity`, `description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, link, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())");
            ps.setString(1, resistor.getName());
            ps.setString(2, resistor.getResistance());
            ps.setFloat(3, resistor.getPercentTolerance());
            ps.setString(4, resistor.getPower());
            ps.setString(5, resistor.getPackageString());
            ps.setInt(6, resistor.getQuantity());
            ps.setString(7, resistor.getDescription());
            ps.setString(8, resistor.getLibraryRef());
            ps.setString(9, resistor.getLibraryPath());
            ps.setString(10, resistor.getFootprintRef());
            ps.setString(11, resistor.getFootprintPath());
            ps.setString(12, resistor.getLink());
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
