package common.target.file;

public interface TargetFile {

    boolean isTargetFile(String filename);

    FileExtension getExtension(String filename);

}
