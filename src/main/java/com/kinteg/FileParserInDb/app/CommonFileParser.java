package com.kinteg.FileParserInDb.app;

import com.kinteg.FileParserInDb.lib.common.model.FullTableModel;

import java.io.File;
import java.util.List;

public interface CommonFileParser {

    List<FullTableModel> parseFile(File file);

    List<FullTableModel> parseFile(File file, long limit);

    FullTableModel parseFile(File file, long limit, String fileName);

    List<String> getFileNames(File file);

}
