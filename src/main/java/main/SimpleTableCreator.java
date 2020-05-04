package main;

import lib.common.model.TableModel;
import lib.common.model.TableModelStatus;

import java.io.File;
import java.util.List;

public interface SimpleTableCreator {

    List<TableModelStatus> createTable(File file);

    List<TableModelStatus> createTable(List<TableModel> tableModel);

    TableModelStatus createTable(TableModel tableModel);

}
