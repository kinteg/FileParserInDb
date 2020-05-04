package lib.parser.archive;

import java.io.Closeable;

public interface ArchiveReader extends Closeable {

    int read(byte[] buffer);

}
