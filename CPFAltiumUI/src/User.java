import java.util.Date;

public class User {
    private String username;
    private String librarypath;
    private Date createddate;
    private Date updateddate;

    public User( String username, String librarypath, Date createddate, Date updateddate) {
        this.username = username;
        this.librarypath = librarypath;
        this.createddate = createddate;
        this.updateddate = updateddate;
    }
}
