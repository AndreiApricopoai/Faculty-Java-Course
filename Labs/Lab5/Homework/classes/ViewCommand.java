package Lab5.Homework.classes;

import Lab5.Homework.exceptions.InvalidDocumentException;
import Lab5.Homework.interfaces.Command;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type View command.
 */
public class ViewCommand implements Command<Void> {

    private Document targetDocument;


    /**
     * Instantiates a new View command.
     */
    public ViewCommand() {
        this.targetDocument = null;
    }

    /**
     * Instantiates a new View command.
     *
     * @param targetDocument the target document
     */
    public ViewCommand(Document targetDocument) {
        this.targetDocument = targetDocument;
    }

    /**
     * Gets target path.
     *
     * @return the target path
     */
    public Document getTargetPath() {
        return targetDocument;
    }

    /**
     * Sets target path.
     *
     * @param targetDocument the target document
     */
    public void setTargetPath(Document targetDocument) {
        this.targetDocument = targetDocument;
    }



    @Override
    public Void execute() throws IOException, InvalidDocumentException {

        if(this.targetDocument == null)
            throw new InvalidDocumentException("Cannot open/view an empty/null document!");

        else if(this.targetDocument.getPath() == null || this.targetDocument.getPath().isEmpty())
            throw new InvalidDocumentException("Empty or null path!");

        else
        {
            Path pathObject = Paths.get(this.targetDocument.getPath());
            if(Files.exists(pathObject) && Files.isRegularFile(pathObject)){

                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.OPEN))
                        desktop.open(new File(this.targetDocument.getPath()));
                }
                else throw new InvalidDocumentException("View Action is not supported by environment!");
            }
            else throw new InvalidDocumentException("Invalid path!");
        }
        return null;
    }



}
