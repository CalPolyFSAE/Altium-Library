import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class FileChooser extends JFileChooser {
    public FileChooser(String filepath){
        super(new File(filepath));
        this.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    }
}
