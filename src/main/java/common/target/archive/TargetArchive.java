package common.target.archive;

public interface TargetArchive {

    boolean isTargetArchive(String filename);

    ArchiveExtension getExtension(String filename);

}
