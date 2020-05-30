package com.kinteg.FileParserInDb.lib.parser.archive.impl.reader;

import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveReader;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.IOException;

public class SevenZFileImpl implements ArchiveReader {

    private final SevenZFile sevenZFile;

    public SevenZFileImpl(SevenZFile sevenZFile) {
        this.sevenZFile = sevenZFile;
    }

    @Override
    public int read(byte[] buffer) {
        try {
            return sevenZFile.read(buffer);
        } catch (IOException e) {
            return -1;
        }
    }

    @Override
    public void close() throws IOException {
        sevenZFile.close();
    }
}
