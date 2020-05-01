package common.target.file;

import lombok.Getter;

@Getter
public enum FileExtension {

    CSV("csv"),
    TXT("txt"),
    XLSX("xlsx"),
    NON_TARGET("non target");

    private String extension;

    FileExtension(String extension) {
        this.extension = extension;
    }

}
