package parser.archive.impl;

import parser.archive.ArchiveParser;

import java.io.File;
import java.io.IOException;
import java.util.List;


class ArchiveHelper implements ArchiveParser {
    @Override
    public File getFile(File zip, String name) throws IOException {
        return null;
    }

    @Override
    public List<File> getFiles(File file) throws IOException {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
