package main;

import common.model.FullTableModel;

import java.io.File;
import java.util.List;

public interface SimpleFileParser {

    List<FullTableModel> parseFile(File file);

    List<FullTableModel> parseFile(File file, long limit);

}
