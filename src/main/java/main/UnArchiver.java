package main;

import java.io.File;
import java.util.List;

public interface UnArchiver {

    List<File> unArchiveFiles(File file);

    File unArchiveFile(File file, String filename);

}
