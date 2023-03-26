package Lab5.Homework.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Lab5.Homework.exceptions.InvalidCatalogException;
import Lab5.Homework.interfaces.Command;

/**
 * The type List command.
 */
public class ListCommand implements Command<Void> {


    private Catalog targetCatalog;


    /**
     * Instantiates a new List command.
     */
    public ListCommand() {
        this.targetCatalog = null;
    }

    /**
     * Instantiates a new List command.
     *
     * @param targetCatalog the target catalog
     */
    public ListCommand(Catalog targetCatalog) {
        this.targetCatalog = targetCatalog;
    }


    /**
     * Gets target catalog.
     *
     * @return the target catalog
     */
    public Catalog getTargetCatalog() {
        return this.targetCatalog;
    }

    /**
     * Sets target catalog.
     *
     * @param targetCatalog the target catalog
     */
    public void setTargetCatalog(Catalog targetCatalog) {
        this.targetCatalog = targetCatalog;
    }



    @Override
    public Void execute() throws InvalidCatalogException, JsonProcessingException {

        if(this.targetCatalog == null)
            throw new InvalidCatalogException("Trying to list the documents of a null Catalog!");
        else{
            ObjectMapper objectMapper = new ObjectMapper();
            String formattedContent = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.targetCatalog);
            System.out.println(formattedContent);
        }

        return null;
    }
}
