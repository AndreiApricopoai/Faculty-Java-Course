package Lab5.Homework.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import Lab5.Homework.exceptions.InvalidCatalogException;
import Lab5.Homework.interfaces.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Save command.
 */
public class SaveCommand implements Command<Void> {


    private Catalog targetCatalog;
    private String targetPath;


    /**
     * Instantiates a new Save command.
     */
    public SaveCommand() {
        this.targetCatalog = null;
        this.targetPath = null;
    }

    /**
     * Instantiates a new Save command.
     *
     * @param targetCatalog the target catalog
     * @param targetPath    the target path
     */
    public SaveCommand(Catalog targetCatalog, String targetPath) {
        this.targetCatalog = targetCatalog;
        this.targetPath = targetPath;
    }


    /**
     * Gets target catalog.
     *
     * @return the target catalog
     */
    public Catalog getTargetCatalog() {
        return targetCatalog;
    }

    /**
     * Sets target catalog.
     *
     * @param targetCatalog the target catalog
     */
    public void setTargetCatalog(Catalog targetCatalog) {
        this.targetCatalog = targetCatalog;
    }

    /**
     * Gets target path.
     *
     * @return the target path
     */
    public String getTargetPath() {
        return targetPath;
    }

    /**
     * Sets target path.
     *
     * @param targetPath the target path
     */
    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }



    @Override
    public Void execute() throws IOException, InvalidCatalogException {

        if(this.targetPath == null || this.targetPath.isEmpty())
            throw new InvalidCatalogException("Empty or null path!");

        else if (this.targetCatalog == null)
            throw new InvalidCatalogException("Cannot save an empty/null catalog!");

        else {

            Path pathObject = Paths.get(this.targetPath);
            if (Files.exists(pathObject)) {

                ObjectMapper objectMapper = new ObjectMapper();
                String modifiedPath = this.targetPath;

                if (Files.isDirectory(pathObject))
                    modifiedPath = modifiedPath + "\\" + this.targetCatalog.getName() + ".json";


                objectMapper.writeValue(new File(modifiedPath), this.targetCatalog);

            } else throw new InvalidCatalogException("Invalid path!");

        }

        return null;
    }
}
