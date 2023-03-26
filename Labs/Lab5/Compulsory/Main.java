package Lab5.Compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Catalog catalog = new Catalog("My First Catalog");

        Document document1 = new Document(1, "book", "C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example");
        Document document2 = new Document(2, "article","C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example");
        Document document3 = new Document(3, "paper","C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example");

        catalog.add(document1)
                .add(document2)
                .add(document3);

        try {
            CatalogUtil.save(catalog,"C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example\\catalog.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Catalog load = CatalogUtil.load("C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example\\catalog.json");
            CatalogUtil.view("C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example\\catalog.json");

        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        }

    }
}