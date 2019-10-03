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
                    "INSERT INTO bjts (name, type, power, beta, ic, vcemax, package, quantity, Description, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, link, createdby, createddate, updatedby, updateddate)"+
                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())");
            ps.setString(1, bjt.getName());
            ps.setString(2, bjt.getType());
            ps.setFloat(3, bjt.getPower());
            ps.setFloat(4, bjt.getBeta());
            ps.setFloat(5, bjt.getIc());
            ps.setFloat(6, bjt.getVcemax());
            ps.setString(7, bjt.getPackageString());
            ps.setInt(8, bjt.getQuantity());
            ps.setString(9, bjt.getDescription());
            ps.setString(10, bjt.getLibraryRef());
            ps.setString(11, bjt.getLibraryPath());
            ps.setString(12, bjt.getFootprintRef());
            ps.setString(13, bjt.getFootprintPath());
            ps.setString(14, bjt.getLink());
            ps.setString(15, DefaultData.name);
            ps.setString(16, DefaultData.name);

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
