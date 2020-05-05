package com.kinteg.FileParserInDb.main.impl;

import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;
import com.kinteg.FileParserInDb.lib.parser.file.parser.FileParser;
import com.kinteg.FileParserInDb.lib.parser.file.parser.impl.FileParserImpl;
import com.kinteg.FileParserInDb.main.UnArchiver;
import com.kinteg.FileParserInDb.main.CommonFileParser;

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