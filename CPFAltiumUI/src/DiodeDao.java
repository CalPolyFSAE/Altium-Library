import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class DiodeDao {
    private Connection connection;

    public DiodeDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Diode diode){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`diodes` (`id`, `name`, `current`, `voltage`, `type`, `numcircuits`, `ic`, `power`, `package`, `quantity`, `location`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())");
            ps.setString(1, diode.getName());
            ps.setFloat(2, diode.getCurrent());
            ps.setFloat(3, diode.getVoltage());
            ps.setString(4, diode.getType());
            ps.setInt(5, diode.getNumcircuits());
            ps.setFloat(6, diode.getIc());
            ps.setFloat(7, diode.getPower());
            ps.setString(8, diode.getPackageString());
            ps.setInt(9, diode.getQuantity());
            //ps.setString(10, diode.getLocation());
            ps.setString(11, diode.getDescription());
            ps.setString(12, diode.getLibraryRef());
            ps.setString(13, diode.getLibraryPath());
            ps.setString(14, diode.getFootprintRef());
            ps.setString(15, diode.getFootprintPath());
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
