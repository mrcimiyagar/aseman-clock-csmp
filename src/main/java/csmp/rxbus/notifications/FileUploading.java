package csmp.rxbus.notifications;

import csmp.models.DocTypes;
import csmp.models.Entities;

public class FileUploading {

    private DocTypes docType;
    private Entities.File file;
    private Entities.FileLocal fileLocal;

    public FileUploading(DocTypes docType, Entities.File file, Entities.FileLocal fileLocal) {
        this.docType = docType;
        this.file = file;
        this.fileLocal = fileLocal;
    }

    public DocTypes getDocType() {
        return docType;
    }

    public Entities.File getFile() {
        return file;
    }

    public Entities.FileLocal getFileLocal() {
        return fileLocal;
    }
}
