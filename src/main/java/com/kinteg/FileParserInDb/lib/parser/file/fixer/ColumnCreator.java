package com.kinteg.FileParserInDb.lib.parser.file.fixer;

import com.kinteg.FileParserInDb.lib.common.model.DataModel;

import java.util.List;

public interface ColumnCreator {

    List<DataModel> createColumns(List<String> nameColumns);

}
