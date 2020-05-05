package com.kinteg.FileParserInDb.main;

import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;

import java.io.File;
import java.util.List;

public interface CommonFileParser {

    List<FullTableModel> parseFile(File file);

    List<FullTableModel> parseFile(File file, long limit);

}
