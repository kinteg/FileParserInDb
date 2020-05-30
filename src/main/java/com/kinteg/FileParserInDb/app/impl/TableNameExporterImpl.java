package com.kinteg.FileParserInDb.app.impl;

import com.kinteg.FileParserInDb.app.TableNameExporter;
import com.kinteg.FileParserInDb.lib.db.exporter.NameExporterRepo;
import com.kinteg.FileParserInDb.lib.db.exporter.impl.NameExporterRepoImpl;

import java.sql.Connection;
import java.util.List;

public class TableNameExporterImpl implements TableNameExporter {

    private final NameExporterRepo nameExporterRepo;

    public TableNameExporterImpl(Connection connection) {
        nameExporterRepo = new NameExporterRepoImpl(connection);
    }

    @Override
    public List<String> getTableNames() {
        return nameExporterRepo.exportNames();
    }

}
