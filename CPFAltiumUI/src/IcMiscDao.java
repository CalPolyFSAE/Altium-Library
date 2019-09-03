import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IcMiscDao {

    private Connection connection;

    public IcMiscDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(IcMisc icMisc){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`icmisc` (`id`, `name`, `vcc`, `voltageinmax`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, icMisc.getName());
            ps.setString(2, icMisc.getVcc());
            ps.setFloat(3, icMisc.getVoltageInMax());
            ps.setString(4, icMisc.getPackageString());
            ps.setInt(5, icMisc.getQuantity());
            ps.setString(6, icMisc.getDescription());
            ps.setString(7, icMisc.getLibraryRef());
            ps.setString(8, icMisc.getLibraryPath());
            ps.setString(9, icMisc.getFootprintRef());
            ps.setString(10, icMisc.getFootprintPath());
            ps.setString(11, icMisc.getLink());
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
