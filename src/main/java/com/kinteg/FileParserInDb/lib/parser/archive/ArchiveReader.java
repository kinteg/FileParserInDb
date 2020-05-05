package com.kinteg.FileParserInDb.lib.parser.archive;

import java.io.Closeable;

public interface ArchiveReader extends Closeable {

    int read(byte[] buffer);

}
