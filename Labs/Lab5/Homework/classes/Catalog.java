package Lab5.Homework.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Catalog.
 */
public class Catalog implements Serializable {

    private String name;
    private List<Document> documents;


    /**
     * Instantiates a new Catalog.
     *
     * @param name the name
     */
    public Catalog(String name) {
        this.name = name;
        this.documents = new ArrayList<>();
    }

    /**
     * Instantiates a new Catalog.
     *
     * @param documents the documents
     */
    @JsonCreator
    public Catalog(@JsonProperty("documents") List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Instantiates a new Catalog.
     *
     * @param name      the name
     * @param documents the documents
     */
    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }


    /**
     * Add catalog.
     *
     * @param document the document
     * @return the catalog
     */
    public Catalog add(Document document) {
        documents.add(document);
        return this;
    }


    /**
     * Remove.
     *
     * @param document the document
     * @return the catalog
     */
    public Catalog remove(Document document){
        documents.remove(document);
        return this;
    }


    /**
     * Find by id document.
     *
     * @param id the id
     * @return the document
     */
    public Document findById(int id) {
        for(Document document : documents){
            if(document.getId() == id)
                return document;
        }
        return null;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets documents.
     *
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Sets documents.
     *
     * @param documents the documents
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }
}
