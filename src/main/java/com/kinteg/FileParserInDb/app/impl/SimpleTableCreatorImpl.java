package com.kinteg.FileParserInDb.app.impl;

import com.kinteg.FileParserInDb.app.SimpleTableCreator;
import com.kinteg.FileParserInDb.app.UnArchiver;
import com.kinteg.FileParserInDb.lib.common.model.TableModel;
import com.kinteg.FileParserInDb.lib.common.model.TableModelStatus;
import com.kinteg.FileParserInDb.lib.db.creator.CreatorRepo;
import com.kinteg.FileParserInDb.lib.db.creator.impl.PostgresqlCreatorRepo;
import com.kinteg.FileParserInDb.lib.parser.file.parser.SimpleFileParser;
import com.kinteg.FileParserInDb.lib.parser.file.parser.impl.SimpleFileParserImpl;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTableCreatorImpl implements SimpleTableCreator {

    private final SimpleFileParser simpleFileParser;
    private final CreatorRepo creatorRepo;
    private final UnArchiver unArchiver;

    public SimpleTableCreatorImpl(Connection connection) {
        simpleFileParser = new SimpleFileParserImpl();
        creatorRepo = new PostgresqlCreatorRepo(connection);
        unArchiver = new UnArchiverImpl();
    }

    @Override
    public List<TableModelStatus> createTable(File file) {
        List<File> files = unArchiver.unArchiveFiles(file);
        List<TableModel> tableModels = simpleFileParser.getFullTable(files);

        return createTable(tableModels);
    }

    @Override
    public List<TableModelStatus> createTable(List<TableModel> tableModel) {
        return tableModel.stream().map(this::createTable).collect(Collectors.toList());
    }

    @Override
    public TableModelStatus createTable(TableModel tableModel) {
        System.out.println(tableModel);
        return creatorRepo.createTable(tableModel);
    }

}
