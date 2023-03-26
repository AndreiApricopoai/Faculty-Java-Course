package Lab5.Compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Document.
 */
public class Document implements Serializable {

    private int id;
    private String type;
    private String path;
    private Map<String, Object> tags;


    /**
     * Instantiates a new Document.
     */
    public Document() {
    }

    /**
     * Instantiates a new Document.
     *
     * @param id   the id
     * @param type the type
     * @param path the path
     */
    public Document(int id, String type, String path) {
        this.id = id;
        this.type = type;
        this.path = path;
        this.tags = new HashMap<>();
    }


    /**
     * Instantiates a new Document.
     *
     * @param id   the id
     * @param type the type
     * @param path the path
     * @param tags the tags
     */
    public Document(int id, String type, String path, Map<String, Object> tags) {
        this.id = id;
        this.type = type;
        this.path = path;
        this.tags = tags;
    }


    /**
     * Add tag.
     *
     * @param key the key
     * @param obj the obj
     */
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public Map<String, Object> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + type + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                '}';
    }
}
