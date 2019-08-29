import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class BjtDao{
    private Connection connection;

    public BjtDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Bjt bjt){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO bjts (name, current, type, power, hfe, ic, vcemax, package, quantity, location, Description, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, createdby, createddate, updatedby, updateddate)"+
                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())");
            ps.setString(1, bjt.getName());
            ps.setFloat(2, bjt.getCurrent());
            ps.setString(3, bjt.getType());
            ps.setFloat(4, bjt.getPower());
            ps.setFloat(5, bjt.getHfe());
            ps.setFloat(6, bjt.getIc());
            ps.setFloat(7, bjt.getVcemax());
            ps.setString(8, bjt.getPackageString());
            ps.setInt(9, bjt.getQuantity());
            ps.setString(10, bjt.getLocation());
            ps.setString(11, bjt.getDescription());
            ps.setString(12, bjt.getLibraryRef());
            ps.setString(13, bjt.getLibraryPath());
            ps.setString(14, bjt.getFootprintRef());
            ps.setString(15, bjt.getFootprintPath());
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
