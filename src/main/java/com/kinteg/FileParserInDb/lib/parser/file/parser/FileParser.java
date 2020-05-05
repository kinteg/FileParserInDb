package com.kinteg.FileParserInDb.lib.parser.file.parser;

import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;
import com.kinteg.FileParserInDb.lib.common.model.TableModel;

import java.io.File;
import java.util.List;

public interface FileParser {

    List<FullTableModel> getFullTable(List<File> files, long limit);

    FullTableModel getFullTable(File file, long limit);

    FullTableModel getFullTable(File file, long limit, TableModel tableModel);

}
