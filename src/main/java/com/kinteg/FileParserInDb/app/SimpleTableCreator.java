package com.kinteg.FileParserInDb.app;

import com.kinteg.FileParserInDb.lib.common.model.TableModel;
import com.kinteg.FileParserInDb.lib.common.model.TableModelStatus;

import java.io.File;
import java.util.List;

public interface SimpleTableCreator {

    List<TableModelStatus> createTable(File file);

    List<TableModelStatus> createTable(List<TableModel> tableModel);

    TableModelStatus createTable(TableModel tableModel);

}
