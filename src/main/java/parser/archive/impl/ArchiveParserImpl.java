package parser.archive.impl;

import parser.archive.ArchiveParser;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ArchiveParserImpl implements ArchiveParser {

    @Override
    public File getFile(File zip, String name) {
        return null;
    }

    @Override
    public List<File> getFiles(File file) {
        return Collections.emptyList();
    }

    @Override
    public void close() {
    }

}
