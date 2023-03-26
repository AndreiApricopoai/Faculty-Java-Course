package Lab5.Homework.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import freemarker.template.TemplateException;
import Lab5.Homework.exceptions.InvalidCatalogException;
import Lab5.Homework.exceptions.InvalidDocumentException;
import Lab5.Homework.exceptions.InvalidReportException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidCatalogException, IOException, InvalidDocumentException {

        Catalog catalog = new Catalog("My First Catalog");

        Document document1 = new Document(1, "book", "C:\\Users\\haske\\Desktop\\Homework5\\src\\main\\java\\org\\example\\documents\\ceva.txt");
        Document document2 = new Document(2, "article","C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example");
        Document document3 = new Document(3, "paper","C:\\Users\\haske\\Desktop\\Compulsory5\\src\\main\\java\\org\\example");

        catalog.add(document1)
                .add(document2)
                .add(document3);

        ListCommand lister = new ListCommand(catalog);

        try {
            lister.execute();
        } catch (InvalidCatalogException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        SaveCommand saver = new SaveCommand(catalog,"C:\\Users\\haske\\Desktop\\Homework5\\src\\main\\java\\org\\example\\documents");
        saver.execute();


        ViewCommand viewer = new ViewCommand(catalog.findById(1));
        viewer.execute();




        ReportCommand reporter = new ReportCommand(catalog,"C:\\Users\\haske\\Desktop\\Homework5\\src\\main\\java\\org\\example\\documents\\report.html");
        try {
            reporter.execute();
        } catch (InvalidReportException | IOException | TemplateException e) {
            e.printStackTrace();
        }


    }
}