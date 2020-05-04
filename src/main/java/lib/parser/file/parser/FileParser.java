package lib.parser.file.parser;

import lib.common.model.FullTableModel;
import lib.common.model.TableModel;

import java.io.File;
import java.util.List;

public interface FileParser {

    List<FullTableModel> getFullTable(List<File> files, long limit);

    FullTableModel getFullTable(File file, long limit);

    FullTableModel getFullTable(File file, long limit, TableModel tableModel);

}
