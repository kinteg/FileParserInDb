package com.kinteg.FileParserInDb.app.impl;

import com.kinteg.FileParserInDb.app.CommonFileParser;
import com.kinteg.FileParserInDb.app.UnArchiver;
import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;
import com.kinteg.FileParserInDb.lib.parser.file.parser.FileParser;
import com.kinteg.FileParserInDb.lib.parser.file.parser.impl.FileParserImpl;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public FullTableModel parseFile(File file, long limit, String fileName) {
        File targetFile = unArchiver.unArchiveFile(file, fileName);
        return fileParser.getFullTable(targetFile, limit);
    }

    @Override
    public List<String> getFileNames(File file) {
        return unArchiver.unArchiveFiles(file)
                .stream().map(File::getName)
                .collect(Collectors.toList());
    }

}