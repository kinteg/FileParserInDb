package main.impl;

import lib.common.model.FullTableModel;
import lib.parser.file.parser.FileParser;
import lib.parser.file.parser.impl.FileParserImpl;
import main.CommonFileParser;
import main.UnArchiver;

import java.io.File;
import java.util.List;

public class CommonFileParserImpl implements CommonFileParser {

    private final long CUSTOM_COLUMN_LIMIT = 5;

    private final FileParser fileParser;
    private final UnArchiver unArchiver;

    public CommonFileParserImpl() {
        fileParser = new FileParserImpl();
        unArchiver = new UnArchiverImpl();
    }

    @Override
    public List<FullTableModel> parseFile(File file) {
        return parseFile(file, CUSTOM_COLUMN_LIMIT);
    }

    @Override
    public List<FullTableModel> parseFile(File file, long limit) {
        List<File> files = unArchiver.unArchiveFiles(file);
        return fileParser.getFullTable(files, limit);
    }

}