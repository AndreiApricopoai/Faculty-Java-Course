package Lab5.Compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The type Catalog util.
 */
public class CatalogUtil {

    /**
     * Save.
     *
     * @param catalog the catalog
     * @param path    the path
     * @throws IOException the io exception
     */
    public static void save(Catalog catalog, String path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }


    /**
     * Load catalog.
     *
     * @param path the path
     * @return the catalog
     * @throws InvalidCatalogException the invalid catalog exception
     * @throws IOException             the io exception
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);

        if(catalog == null)
            throw  new InvalidCatalogException("Invalid data or bad file!");

        return catalog;
    }


    /**
     * View.
     *
     * @param path the path
     */
    public static void view(String path) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                try {
                    desktop.open(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
