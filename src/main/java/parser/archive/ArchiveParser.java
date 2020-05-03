package parser.archive;

import java.io.File;
import java.util.List;

public interface ArchiveParser extends AutoCloseable {

    File getFile(File zip, String name);

    List<File> getFiles(File file);

}
