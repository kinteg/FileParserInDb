package com.kinteg.FileParserInDb.lib.db.exporter;

import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;

public interface TableExporter {

    FullTableModel tableExporter(String tableName, int limit);

}
