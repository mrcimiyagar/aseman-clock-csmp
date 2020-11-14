package csmp.rxbus.notifications;

import csmp.models.DocTypes;
import csmp.models.Entities;

public class FileDownloading {

    private DocTypes docType;
    private Entities.File file;

    public FileDownloading(DocTypes docType, Entities.File file) {
        this.docType = docType;
        this.file = file;
    }

    public DocTypes getDocType() {
        return docType;
    }

    public Entities.File getFile() {
        return file;
    }
}
