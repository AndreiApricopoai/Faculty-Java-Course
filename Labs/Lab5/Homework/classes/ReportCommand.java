package Lab5.Homework.classes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import Lab5.Homework.exceptions.InvalidReportException;
import Lab5.Homework.interfaces.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Report command.
 */
public class ReportCommand implements Command<Void> {

    private Catalog targetCatalog;
    private String reportPath;

    /**
     * Instantiates a new Report command.
     */
    public ReportCommand() {
        this.targetCatalog = null;
        this.reportPath = null;
    }


    /**
     * Instantiates a new Report command.
     *
     * @param targetCatalog the target catalog
     * @param reportPath    the report path
     */
    public ReportCommand(Catalog targetCatalog, String reportPath) {
        this.targetCatalog = targetCatalog;
        this.reportPath = reportPath;
    }

    /**
     * Gets report path.
     *
     * @return the report path
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Sets report path.
     *
     * @param reportPath the report path
     */
    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    /**
     * Instantiates a new Report command.
     *
     * @param targetCatalog the target catalog
     */
    public ReportCommand(Catalog targetCatalog) {
        this.targetCatalog = targetCatalog;
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



    @Override
    public Void execute() throws InvalidReportException, IOException, TemplateException {

        if(this.targetCatalog == null)
            throw new InvalidReportException("Cannot generate a report for an empty/null catalog!");
        else if(this.reportPath == null || this.reportPath.isEmpty())
            throw new InvalidReportException("Empty or null report path!");
        else{

            // Configure FreeMarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/");
            cfg.setDefaultEncoding("UTF-8");

            // Create the data model
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("catalog", targetCatalog);

            // Get the template
            Template template = cfg.getTemplate("report.ftlh");

            // Write the output
            try (Writer writer = new FileWriter(this.reportPath)) {
                template.process(dataModel, writer);
            }

            // Open the report in the default system browser
            Path reportPath = Paths.get(this.reportPath);
            if (Files.exists(reportPath)) {
                File reportFile = new File(this.reportPath);
                java.awt.Desktop.getDesktop().open(reportFile);
            }

            else throw new InvalidReportException("Failed to generate report!");

        }
        return null;
    }
}

