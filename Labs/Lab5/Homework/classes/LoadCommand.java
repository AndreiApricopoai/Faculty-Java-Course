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
 * The type Load command.
 */
public class LoadCommand implements Command<Catalog> {


    private String targetPath;


    /**
     * Instantiates a new Load command.
     */
    public LoadCommand() {
        this.targetPath = null;
    }

    /**
     * Instantiates a new Load command.
     *
     * @param path the path
     */
    public LoadCommand(String path) {
        this.targetPath = path;
    }

    /**
     * Set target path.
     *
     * @param newPath the new path
     */
    public void setTargetPath(String newPath){
        this.targetPath = newPath;
    }

    /**
     * Get target path string.
     *
     * @return the string
     */
    public String getTargetPath(){
        return this.targetPath;
    }

    @Override
    public Catalog execute() throws IOException, InvalidCatalogException {

        if(this.targetPath == null || this.targetPath.isEmpty()) {
            throw new InvalidCatalogException("Empty or null path!");
        }
        else{
            Path pathObject = Paths.get(this.targetPath);
            if(Files.exists(pathObject) && Files.isRegularFile(pathObject)){

                ObjectMapper objectMapper = new ObjectMapper();
                Catalog catalog = objectMapper.readValue(new File(this.targetPath), Catalog.class);
                if (catalog == null)
                    throw new InvalidCatalogException("Invalid/Corrupted catalog file or the file is not a catalog!");
                return catalog;
            }

            else throw new InvalidCatalogException("Invalid path!");
        }
    }




}
