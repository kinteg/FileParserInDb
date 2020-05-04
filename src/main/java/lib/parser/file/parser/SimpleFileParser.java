package lib.parser.file.parser;

import lib.common.model.TableModel;

import java.io.File;
import java.util.List;

public interface SimpleFileParser {

    List<TableModel> getFullTable(List<File> files);

    TableModel getFullTable(File file);


}
